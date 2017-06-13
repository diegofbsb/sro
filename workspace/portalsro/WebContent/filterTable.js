/*====================================================
	- HTML Table Filter Generator v1.5
	- By Max Guglielmi
	- mguglielmi.free.fr/scripts/TableFilter/?l=en
	- please do not change this comment
	- don't forget to give some credit... it's always
	good for the author
=====================================================*/

var TblId, StartRow, SearchFlt, ModFn, ModFnId;
var ExactMatchId, ExactMatch, isPageChanged;
TblId = new Array(), StartRow = new Array();
ModFn = new Array(), ModFnId = new Array();
ExactMatchId = new Array(), ExactMatch = new Array();
SlcArgs = new Array(), isPageChanged = false;


function setFilterGrid(id)
/*====================================================
	- Checks if id exists and is a table
	- Then looks for additional params 
	- Calls fn that adds inputs and button
=====================================================*/
{
	var tbl = document.getElementById(id);
	var ref_row, fObj;
	if(tbl != null && tbl.nodeName.toLowerCase() == "table")
	{
		TblId.push(id);		
		if(arguments.length>1)
		{
			for(var i=0; i<arguments.length; i++)
			{
				var argtype = typeof arguments[i];
				
				switch(argtype.toLowerCase())
				{
					case "number":
						ref_row = arguments[i];
					break;
					case "object":
						fObj = arguments[i];
					break;
				}//switch
							
			}//for
		}//if
		
		ref_row == undefined ? StartRow.push(2) : StartRow.push(ref_row+2);
		var ncells = getCellsNb(id,ref_row);
		AddRow(id,ncells,fObj);		
	}
}

function AddRow(id,n,f)
/*====================================================
	- adds a row containing the filtering grid
=====================================================*/
{	
	var t = document.getElementById(id);
	var fltrow = t.insertRow(0);
	var inpclass, displayBtn, btntext, enterkey;
	var modfilter_fn, display_allText, on_slcChange;
	var displaynrows, totrows_text, btnreset, btnreset_text;
	var sort_slc, displayPaging, pagingLength, displayLoader;
	var load_text, exactMatch;
	
	f!=undefined && f["btn"]==false ? displayBtn = false : displayBtn = true;//shows/hides button
	f!=undefined && f["btn_text"]!=undefined ? btntext = f["btn_text"] : btntext = "go";//defines button text
	f!=undefined && f["enter_key"]==false ? enterkey = false : enterkey = true;//enables/disables enter key
	f!=undefined && f["mod_filter_fn"] ? modfilter_fn = true : modfilter_fn = false;//defines alternative fn
	f!=undefined && f["display_all_text"]!=undefined ? display_allText = f["display_all_text"] : display_allText = "";//defines 1st option text
	f!=undefined && f["on_change"]==true ? on_slcChange = true : on_slcChange = false;//enables/disables onChange event on combo-box 
	f!=undefined && f["display_nrows"]==true ? displaynrows = true : displaynrows = false;//show/hides rows counter
	f!=undefined && f["nrows_text"]!=undefined ? totrows_text = f["nrows_text"] : totrows_text = "Data rows: ";//defines rows counter text
	f!=undefined && f["btn_reset"]==true ? btnreset = true : btnreset = false;//show/hides reset link
	f!=undefined && f["btn_reset_text"]!=undefined ? btnreset_text = f["btn_reset_text"] : btnreset_text = "Reset";//defines reset text
	f!=undefined && f["sort_select"]==true ? sort_slc = true : sort_slc = false;//enables/disables select options sorting
	f!=undefined && f["paging"]==true ? displayPaging = true : displayPaging = false;//enables/disables table paging
	f!=undefined && f["paging_length"]!=undefined ? pagingLength = f["paging_length"] : pagingLength = 10;//defines table paging length
	f!=undefined && f["loader"]==true ? displayLoader= true : displayLoader = false;//enables/disables loader
	f!=undefined && f["loader_text"]!=undefined ? load_text = f["loader_text"] : load_text = "Loading...";//defines loader text
	f!=undefined && f["exact_match"]==true ? exactMatch= true : exactMatch = false;//enables/disbles exact match for search
	

	if(modfilter_fn) 
	{
		ModFnId.push(id);// used by DetectKey fn
		ModFn.push(f["mod_filter_fn"]);
	}
	
	if(exactMatch)
	{
		ExactMatchId.push(id);// used by DetectKey fn
		ExactMatch.push(exactMatch);
	}	

	if(displaynrows || btnreset || displayPaging || displayLoader)
	{
		
		/*** div containing rows # displayer + reset btn ***/
		var infdiv = document.createElement("div");
		infdiv.setAttribute("id","inf_"+id);
		infdiv.className = "inf";
		t.parentNode.insertBefore(infdiv, t);
		
		if(displaynrows)
		{
			/*** left div containing rows # displayer ***/
			var totrows;
			var ldiv =  document.createElement("div");
			ldiv.setAttribute("id","ldiv_"+id);
			displaynrows ? ldiv.className = "ldiv" : ldiv.style.display = "none";
			displayPaging ? totrows = pagingLength : totrows = getRowsNb(id);
			
			var totrows_span = document.createElement("span"); // tot # of rows displayer 
			totrows_span.setAttribute("id","totrows_span_"+id);
			totrows_span.className = "tot";
			totrows_span.appendChild( document.createTextNode(totrows) );
		
			var totrows_txt = document.createTextNode(totrows_text);
			ldiv.appendChild(totrows_txt);
			ldiv.appendChild(totrows_span);
			infdiv.appendChild(ldiv);
		}
		
		if(displayLoader)
		{
			/*** div containing loader  ***/
			var loaddiv =  document.createElement("div");
			loaddiv.setAttribute("id","load_"+id);
			loaddiv.className = "loader";
			loaddiv.style.display = "none";
			loaddiv.appendChild(document.createTextNode(load_text));	
			infdiv.appendChild(loaddiv);
		}
				
		if(displayPaging)
		{
			/*** mid div containing paging displayer ***/
			var mdiv =  document.createElement("div");
			mdiv.setAttribute("id","mdiv_"+id);
			displayPaging ? mdiv.className = "mdiv" : mdiv.style.display = "none";						
			infdiv.appendChild(mdiv);
			
			var start_row = getStartRow(id);
			var nrows = t.getElementsByTagName("tr").length;
			var npages = Math.ceil( (nrows - start_row)/pagingLength );
			
			var slcPages = document.createElement("select");
			slcPages.setAttribute("id","slcPages_"+id);
			slcPages.onchange = function(){ 
				isPageChanged = true;
				if(displayLoader) showLoader(id,"");
				GroupByPage(id,pagingLength,this.value);
				if(displayLoader) showLoader(id,"none");
			}
			document.getElementById("mdiv_"+id).appendChild( document.createTextNode(" Page ") );
			document.getElementById("mdiv_"+id).appendChild(slcPages);
			document.getElementById("mdiv_"+id).appendChild( document.createTextNode(" of "+npages+" ") );
			for(var t=0; t<npages; t++)
			{
				var currOpt = new Option((t+1),t*pagingLength,false,false);
				document.getElementById("slcPages_"+id).options[t] = currOpt;
			}
						
			GroupByPage(id,pagingLength,0);//calls paging fn
			if(displayLoader) showLoader(id,"none");
		}
		
		if(btnreset)
		{
			/*** right div containing reset button **/	
			var rdiv =  document.createElement("div");
			rdiv.setAttribute("id","reset_"+id);
			btnreset ? rdiv.className = "rdiv" : rdiv.style.display = "none";
			
			var fltreset = document.createElement("a");
			fltreset.setAttribute("href","javascript:clearFilters('"+id+"');Filter('"+id+"','"+exactMatch+"');");
			fltreset.appendChild(document.createTextNode(btnreset_text));
			rdiv.appendChild(fltreset);
			infdiv.appendChild(rdiv);
		}
		
	}//if


	for(var i=0; i<n; i++)
	{
		var fltcell = fltrow.insertCell(i);
		fltcell.noWrap = true;
		i==n-1 && displayBtn==true ? inpclass = "flt_s" : inpclass = "flt";
		
		if(f==undefined || f["col_"+i]==undefined || f["col_"+i]=="none") 
		{
			var inp = document.createElement("input");		
			inp.setAttribute("id","flt"+i+"_"+id);
			if(f==undefined || f["col_"+i]==undefined) inp.setAttribute("type","text");
			else inp.setAttribute("type","hidden");
			//inp.setAttribute("class","flt"); //doesn't seem to work on ie<=6
			inp.className = inpclass;			
			fltcell.appendChild(inp);
			if(enterkey) inp.onkeypress = DetectKey;
		}
		else if(f["col_"+i]=="select")
		{
			var slc = document.createElement("select");
			slc.setAttribute("id","flt"+i+"_"+id);
			slc.className = inpclass;
			fltcell.appendChild(slc);
			PopulateOptions(id,i,n,display_allText,sort_slc,displayPaging);
			if(displayPaging)//stores arguments for GroupByPage() fn
			{
				var args = new Array();
				args.push(id); args.push(i); args.push(n);
				args.push(display_allText); args.push(sort_slc); args.push(displayPaging);
				SlcArgs.push(args);
			}
			if(enterkey) slc.onkeypress = DetectKey;
			if(on_slcChange) {(!modfilter_fn) ? slc.onchange = function(){ Filter(id,exactMatch); } : slc.onchange = f["mod_filter_fn"];} 
		}
		
		if(i==n-1 && displayBtn==true)// this adds button
		{
			var btn = document.createElement("input");
			
			btn.setAttribute("id","btn"+i+"_"+id);
			btn.setAttribute("type","button");
			btn.setAttribute("value",btntext);
			btn.className = "btnflt";
			
			fltcell.appendChild(btn);
			(!modfilter_fn) ? btn.onclick = function(){ Filter(id,exactMatch); } : btn.onclick = f["mod_filter_fn"];					
		}//if		
		
	}// for i
	
}

function PopulateOptions(id,cellIndex,ncells,opt0txt,sort_opts,paging)
/*====================================================
	- populates select
	- adds only 1 occurence of a value
=====================================================*/
{
	var t = document.getElementById(id);
	var start_row = getStartRow(id);
	var row = t.getElementsByTagName("tr");
	var OptArray = new Array();
	var optIndex = 0; // option index
	var currOpt = new Option(opt0txt,"",false,false); //1st option
	document.getElementById("flt"+cellIndex+"_"+id).options[optIndex] = currOpt;
	
	for(var k=start_row; k<row.length; k++)
	{
		var cell = getChildElms(row[k]).childNodes;
		var nchilds = cell.length;
		var isPaged = row[k].getAttribute("paging");
		
		if(nchilds == ncells){// checks if row has exact cell #
			
			for(var j=0; j<nchilds; j++)// this loop retrieves cell data
			{
				if(cellIndex==j)
				{
					var cell_data = getCellText(cell[j]);
					// checks if celldata is already in array
					var isMatched = false;
					for(w in OptArray)
					{
						if( cell_data == OptArray[w] ) isMatched = true;
					}
					if(!isMatched && !paging) OptArray.push(cell_data);
					else if(!isMatched && paging && isPaged=="true") OptArray.push(cell_data);
				}//if cellIndex==j
			}//for j
		}//if
	}//for k
	
	if(sort_opts) OptArray.sort();
	for(y in OptArray)
	{
		optIndex++;
		var currOpt = new Option(OptArray[y],OptArray[y],false,false);
		document.getElementById("flt"+cellIndex+"_"+id).options[optIndex] = currOpt;		
	}
		
}

function Filter(id,ematch)
/*====================================================
	- gets search strings from SearchFlt array
	- retrieves data from each td in every single tr
	and compares to search string for current
	column
	- tr is hidden if all search strings are not 
	found
=====================================================*/
{	
	showLoader(id,"");
	getFilters(id);
	var t = document.getElementById(id);
	var SearchArgs = new Array();
	var ncells = getCellsNb(id);
	var totrows = getRowsNb(id), hiddenrows = 0;
	
	for(var i=0; i<SearchFlt.length; i++)
		SearchArgs.push((document.getElementById(SearchFlt[i]).value).toLowerCase());
	
	var start_row = getStartRow(id);
	var row = t.getElementsByTagName("tr");
	
	for(var k=start_row; k<row.length; k++)
	{	
		/*** if table already filtered some rows are not visible ***/
		if(row[k].style.display == "none") row[k].style.display = "";
		
		var cell = getChildElms(row[k]).childNodes;
		var nchilds = cell.length;

		if(nchilds == ncells){// checks if row has exact cell #
			var cell_value = new Array();
			var occurence = new Array();
			var isRowValid = true;
				
			for(var j=0; j<nchilds; j++)// this loop retrieves cell data
			{
				var cell_data = getCellText(cell[j]).toLowerCase();
				cell_value.push(cell_data);
				
				if(SearchArgs[j]!="")
				{
					var num_cell_data = parseFloat(cell_data);
					
					if(/<=/.test(SearchArgs[j]) && !isNaN(num_cell_data)) // first checks if there is an operator (<,>,<=,>=)
					{
						num_cell_data <= parseFloat(SearchArgs[j].replace(/<=/,"")) ? occurence[j] = true : occurence[j] = false;
					}
					
					else if(/>=/.test(SearchArgs[j]) && !isNaN(num_cell_data))
					{
						num_cell_data >= parseFloat(SearchArgs[j].replace(/>=/,"")) ? occurence[j] = true : occurence[j] = false;
					}
					
					else if(/</.test(SearchArgs[j]) && !isNaN(num_cell_data))
					{
						num_cell_data < parseFloat(SearchArgs[j].replace(/</,"")) ? occurence[j] = true : occurence[j] = false;
					}
										
					else if(/>/.test(SearchArgs[j]) && !isNaN(num_cell_data))
					{
						num_cell_data > parseFloat(SearchArgs[j].replace(/>/,"")) ? occurence[j] = true : occurence[j] = false;
					}					
					
					else 
					{
						var regexp;
						if(ematch) regexp = new RegExp('(^)'+SearchArgs[j]+'($)',"gi");
						else regexp = new RegExp(SearchArgs[j],"gi");
						occurence[j] = regexp.test(cell_data);
					}
				}//if SearchArgs
			}//for j
			
			for(var t=0; t<ncells; t++)
			{
				if(SearchArgs[t]!="" && !occurence[t]) isRowValid = false;
			}//for t
			
		}//if				

		/*** checks if table is paged and displays rows ***/
		var isPaged = row[k].getAttribute("paging"); //retrieves paging attribute
		if(isPaged != null && isPaged != "")
		{
			if( !isRowValid && isPaged=="false" ) { row[k].style.display = "none"; hiddenrows++; }
			else if( isRowValid && isPaged=="true" ) row[k].style.display = ""; 
			else if( isRowValid && isPaged=="false" ){ row[k].style.display = "none"; hiddenrows++; }
			else { row[k].style.display = "none"; hiddenrows++; }
		} else {
			if(!isRowValid) { row[k].style.display = "none"; hiddenrows++; }
			else row[k].style.display = "";
		}
		
	}// for k

	/*** refreshes tot # of rows displayer ***/
	showTotRowsN(id,parseInt(totrows - hiddenrows));
	
	showLoader(id,"none");
}

function GroupByPage(id,pagelength,start)
{
	var t = document.getElementById(id);
	var start_row = parseInt(getStartRow(id));//filter start row
	var paging_start_row = start_row + parseInt(start);//paging start row
	var row = t.getElementsByTagName("tr");
	var nrows = 0, counter = paging_start_row;
	var param1,param2,param3,param4,param5,param6;
	
	for(var j=start_row; j<row.length; j++)//reset all rows to paging=false
	{
		row[j].setAttribute("paging","false"); 
		row[j].style.display = "none";
	}//for j
	
	for(var k=paging_start_row; k<row.length; k++)//shows current page rows
	{
		counter++;
		if(counter<=paging_start_row+pagelength)
		{
			row[k].setAttribute("paging","true");
			row[k].style.display = "";
			nrows++;
		}
	}//for k
	
	if(isPageChanged)
	{
		getFilters(id);
		for(var i=0; i<SlcArgs.length; i++)//this loop retrieves PopulateOptions() fn params
		{
			if(SlcArgs[i][0]==id) 
			{				
				var cSlc;				
				for(var u=0; u<SearchFlt.length; u++)
				{
					cSlc = document.getElementById(SearchFlt[u]);
					if(cSlc.nodeName.toLowerCase()=="select" && u==i )//if current filter is a select
					{
						for(t = cSlc.length-1; t >= 0; t--) cSlc.remove(t);
					}
				}
				param1 = SlcArgs[i][0], param2 = SlcArgs[i][1];
				param3 = SlcArgs[i][2], param4 = SlcArgs[i][3];
				param5 = SlcArgs[i][4], param6 = SlcArgs[i][5];
				PopulateOptions(param1,param2,param3,param4,param5,param6);	
			}
			
		}//for i
		isPageChanged=false;
		
	}//if isPageChanged
	
	/*** refreshes tot # of rows displayer ***/
	if(start > 0) showTotRowsN(id,parseInt(nrows));
}

function getCellsNb(id,nrow)
/*====================================================
	- returns number of cells in a row
	- if nrow param is passed returns number of cells 
	of that specific row
=====================================================*/
{
  	var t = document.getElementById(id);
	var tr;
	if(nrow == undefined) tr = t.getElementsByTagName("tr")[0];
	else  tr = t.getElementsByTagName("tr")[nrow];
	var n = getChildElms(tr);
	return n.childNodes.length;
}

function getRowsNb(id)
/*====================================================
	- returns total nb of rows for a given table
=====================================================*/
{
	var t = document.getElementById(id);
	var s = getStartRow(id);
	var ntrs = t.getElementsByTagName("tr").length;
	return parseInt(ntrs-s);
}

function getFilters(id)
/*====================================================
	- filter (input or select) ids are stored in  
	SearchFlt array
=====================================================*/
{
	SearchFlt = new Array();
	var t = document.getElementById(id);
	var tr = t.getElementsByTagName("tr")[0];
	var enfants = tr.childNodes;
	
	for(var i=0; i<enfants.length; i++) SearchFlt.push(enfants[i].firstChild.getAttribute("id"));
}

function getStartRow(id)
/*====================================================
	- returns starting row for Filter fn for a 
	given table id
=====================================================*/
{
	var r;
	for(j in TblId)
	{
		if(TblId[j] == id) r = StartRow[j];
	}
	return r;
}

function clearFilters(id)
/*====================================================
	- clears grid filters
=====================================================*/
{
	getFilters(id);
	for(i in SearchFlt) document.getElementById(SearchFlt[i]).value = "";
}

function showLoader(id,p)
/*====================================================
	- displays/hides loader div
=====================================================*/
{
	var loaderdiv = document.getElementById("load_"+id);
	if(loaderdiv != null && p=="none")
		setTimeout("document.getElementById('load_"+id+"').style.display = '"+p+"'",250);
	else if(loaderdiv != null && p!="none") loaderdiv.style.display = p;
}

function showTotRowsN(id,p)
/*====================================================
	- Shows total number of filtered rows
=====================================================*/
{
	var totrows_displayer = document.getElementById("totrows_span_"+id);
	if(totrows_displayer != null && totrows_displayer.nodeName.toLowerCase() == "span" ) 
		totrows_displayer.innerHTML = p;
}

function getChildElms(n)
/*====================================================
	- checks passed node is a ELEMENT_NODE nodeType=1
	- removes TEXT_NODE nodeType=3  
=====================================================*/
{
	if(n.nodeType == 1)
	{
		var enfants = n.childNodes;
		for(var i=0; i<enfants.length; i++)
		{
			var child = enfants[i];
			if(child.nodeType == 3) n.removeChild(child);
		}
		return n;	
	}
}

function getCellText(n)
/*====================================================
	- returns text + text of child nodes of a cell
=====================================================*/
{
	var s = "";
	var enfants = n.childNodes;
	for(var i=0; i<enfants.length; i++)
	{
		var child = enfants[i];
		if(child.nodeType == 3) s+= child.data;
		else s+= getCellText(child);
	}
	return s;
}

function DetectKey(e)
{
/*====================================================
	- common fn that detects return key for a given
	element (onkeypress attribute on input)
=====================================================*/
	var evt=(e)?e:(window.event)?window.event:null;
	if(evt){
		var key=(evt.charCode)?evt.charCode:
			((evt.keyCode)?evt.keyCode:((evt.which)?evt.which:0));
		if(key=="13")
		{
			var cid, leftstr, tblid, CallFn, Match;		
			cid = this.getAttribute("id");
			leftstr = this.getAttribute("id").split("_")[0];
			tblid = cid.substring(leftstr.length+1,cid.length);
			for(i in ModFn)	ModFnId[i] == tblid ? CallFn=true : CallFn=false;
			for(j in ExactMatchId){ if(ExactMatchId[j] == tblid) Match = ExactMatch[j]; }
			(CallFn) ? ModFn[i].call() : Filter(tblid,Match);
		}//if key
	}//if evt	
}		