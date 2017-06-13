package br.com.correios.sromonitor.dao;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joseed
 */
public class lerArquivo {
    

     public void ler() throws FileNotFoundException, IOException, SQLException, DAOException{

        String ipCon2 = "", senha2 = "", codigo2 = "", linha = "";
        int a;
        OracleCadastroConcentradorDAO cad = new OracleCadastroConcentradorDAO();
        List listaRegistros = new ArrayList();
        List listaCep = new ArrayList();
        InputStream is = new FileInputStream("D:/usuarios/conscgoropb.csv");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        linha = br.readLine();

        while (linha != null) {
            //numeroLinha +=1;
            String fields[] = linha.split(";");
            a = fields.length;
            System.out.println("tamanho array " + a);
            if (a > 0) {
                for (int b = 0; b < a; b++) {                           //if(a != 9 && a > 0){
                    //a = fields[5].length();
                    if (fields[b].toString().isEmpty()) {
                        fields[b] = "branco";
                        System.out.println("branco " + b + " - " + fields[b].toString());
                    }

//                    if (b == 1) {
//                        codigo2 = fields[b].toString().trim();
//                    } else if (b == 5) {
//                        ipCon2 = fields[5].toString();
//                    } else if (b == 7) {
//                        senha2 = fields[7].toString();
//                    }
                    if (b == 0) {
                        codigo2 = fields[b].toString().trim();
                    } else if (b == 1) {
                        ipCon2 = fields[b].toString();
                    } else if (b == 2) {
                        senha2 = fields[b].toString();
                    }
                    
                }

                        System.out.println(ipCon2 + senha2 + codigo2);
                        if (!ipCon2.equalsIgnoreCase("branco") && !senha2.equalsIgnoreCase("branco") && !codigo2.equalsIgnoreCase("branco")) {
                            String[] registros = {ipCon2.trim(), senha2.trim(), codigo2.trim()};

                            listaRegistros.add(registros);

                        }

            }

            fields = null;
            linha = br.readLine();
        }
        int qtdLinha = 0;
        for (int j = 0; j < listaRegistros.size(); j++) {
            String[] registros = (String[]) listaRegistros.get(j);
            for (String campo : registros) {
                System.out.println("passou");
                if (qtdLinha == 0) {
                    ipCon2 = campo.trim();
                } else if (qtdLinha == 1) {
                    senha2 = campo.trim();
                } else if (qtdLinha == 2) {
                    codigo2 = campo.trim();

                }
                qtdLinha++;
                if (qtdLinha > 2) {
                    qtdLinha = 0;
                    listaCep = cad.getCodigoSroUnidade(codigo2, false);
                    if (!listaCep.isEmpty()) {

                        cad.getUpdateOrCadastraIpConcentrador(ipCon2, senha2, codigo2, true);
                        System.out.println("cadastro atualiza efetuado - " + ipCon2 + " - " + senha2 + " - " + codigo2);
                    } else {
                        cad.getUpdateOrCadastraIpConcentrador(ipCon2, senha2, codigo2, false);
                        System.out.println("cadastro inserido efetuado - " + ipCon2 + " - " + senha2 + " - " + codigo2);
                    }
                }
            }

        }
    }

}
