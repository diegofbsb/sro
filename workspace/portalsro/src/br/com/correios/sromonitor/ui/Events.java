/*
 * Events.java
 *
 * Created on 27 de Novembro de 2006, 17:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.ui;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class Events implements Serializable {
    
    private final Map<String,String> event = Collections.synchronizedMap(new HashMap<String,String>());
    
    /** Creates a new instance of Events */
    public Events() {
        event.put("AI", "Auto de irregularidade.");
        event.put("BDE", "Baixa de distribuição externa.");
        event.put("BDI", "Baixa de distribuição interna.");
        event.put("CAR", "Conferência de registro (automática).");
        event.put("CD", "Conferência de despacho.");
        event.put("CMR", "Conferência de registro (manual).");
        event.put("CMT", "Chegada de um meio de transporte.");
        event.put("CO", "Coleta.");
        event.put("CUN", "Conferência por unidade não automatizada.");
        event.put("DO", "Expedição de recipientes e objetos fora de recipiente.");
        event.put("IDC", "Indenização.");
        event.put("IE", "Irregularidade de expedição.");
        event.put("IT", "Passagem Interna.");
        event.put("LDE", "Triagem.");
        event.put("LDI", "Lançamento para distribuição interna.");
        event.put("OEC", "Lançamento para distribuição externa.");
        event.put("PMT", "Partida de um meio de transporte.");
        event.put("PO", "Postagem.");
        event.put("REV", "Gestão do estoque de recipientes.");
        event.put("RO", "Expedição de objetos e recipientes em recipiente.");
        event.put("TR", "Trânsito.");
        event.put("TRI", "Triagem.");
        event.put("ADEL","LISTA DE CAPTURA PÓS-ENTREGA");
        event.put("ARCL","LISTA DE CONFERÊNCIA DE REGISTRO AUTOMÁTICO");
        event.put("CENU","UNIDADES CENTRALIZADORAS");
        event.put("COLL","LISTA DE COLETA");
        event.put("DCOL","LISTA DE CONFERÊNCIAD E EXPEDIÇÃO");
        event.put("DICL","LISTA DE CÓDIGO DE IRREGULARIDADE DE EXPEDIÇÃO");
        event.put("DIEM","ASSOCIAÇÃO DISTRITO/FUNCIONÁRIO");
        event.put("DISI","IRREGULARIDADE NA EXPEDIÇÃO");
        event.put("DISN","NOTA DE EXPEDIÇÃO");
        event.put("DPRE","PRÉ-ALERTA DE EXPEDIÇÃO");
        event.put("EDEL","LISTA DE DESCRIÇÃO DE EVENTO");
        event.put("FULI","LISTA DE UNIDADE FEDERAL");
        event.put("GEDA","DADOS GERAIS DE UNIDADE OPERACIONAL");
        event.put("GETL","DESCARTABILIDADE GERAL DA LINHA DE TRANSPORTE");
        event.put("GETP","PLANO DE TRANSPORTE GERAL DA UNIDADE OPERACIONAL");
        event.put("HDAY","FERIADOS");
        event.put("ICAL","LISTA DE CAUSA DE INDENIZAÇÃO");
        event.put("IDEN","NOTA DE INDENIZAÇÃO");
        event.put("IDRL","LISTA DE REGISTRO DE ENTREGA INTERNA");
        event.put("IMNL","LISTA DE MEIOS DE INDENIZAÇÃO");
        event.put("INTR","TRANSMISSÃO INTERNA");
        event.put("IRAL","LISTA DE ALVO DE IRREGULARIDADE");
        event.put("IRCL","LISTA DE CÓDIGO DE IRREGULARIDADE");
        event.put("IRRC","CASO DE IRREGULARIDADE");
        event.put("ISND","POSTAGEM DE OBJETOS(GRANDES CLIENTES)");
        event.put("POST","POSTAGEM DE OBJETOS(CLIENTES AVULSOS, SISTEMAS, ACF, ETC)");
        event.put("LEDL","LANÇAMENTO NA LISTA DE ENTREGA EXTERNA");
        event.put("LIDL","LANÇAMENTO NA LISTA DE ENTREGA INTERNA");
        event.put("MRCL","LISTA DE CONFERÊNCIA DE REGISTRO MANUAL");
        event.put("NACL","LISTA DE CONFERÊNCIA DE UNIDADE NÃO AUTOMATIZADA");
        event.put("NDCL","LISTA DE CAUSA DE NÃO-ENTREGA");
        event.put("OTYL","LISTA DE TIPO DE OBJETO");
        event.put("OUDA","DADOS DE UNIDADE OPERACIONAL");
        event.put("OULI","LISTA DE UNIDADES OPERACIONAIS");
        event.put("OUTP","PLANO DE TRANSPORTE DE UNIDADE OPERACIONAL");
        event.put("RDIL","LISTA DE DIRETORIAS REGIONAIS");
        event.put("RDUT","HORÁRIOS DE ATUALIZÇÃO DE DADOS DE REFERÊNCIA");
        event.put("REGL","LISTA DE REGISTRO");
        event.put("RETL","LISTA DE TIPO DE EVENTO DE RECIPIENTE");
        event.put("REVT","EVENTO DE RECIPIENTE");
        event.put("RPRE","PRÉ-ALERTA DE REGISTRO");
        event.put("PPRE","PRÉ-ALERTA DE POSTAGEM");
        event.put("RTYL","LISTA DE TIPO DE RECIPIENTE");
        event.put("SORI","ITEM CLASSIFICADO");
        event.put("TLTL","LISTA DE TIPO DE LINHA DE TRANSPORTE");
        event.put("TMTL","LISTA DE TIPO DE MEIO DE TRANSPORTE");
        event.put("TRAL","LISTA DE TRÂNSITO");
        event.put("TRIA","CHEGADA DE VIAGEM");
        event.put("TRID","SAÍDA PARA VIAGEM");
        event.put("UACC","CONTA DE USUÁRIO");
        event.put("UTYL","LISTA DE TIPO DE UNIDADE OPERACIONAL");
        
    }
    
    public Map<String, String> getEvent() {
        return event;
    }
    
}
