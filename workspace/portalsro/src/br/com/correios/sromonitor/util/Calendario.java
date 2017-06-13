package br.com.correios.sromonitor.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;



public class Calendario {

    /**
     * Retorna a data atual no formato dd/MM/yyyy
     * @return String no formato dd/MM/yyyy
     */
    public static String obterDataAtual() {
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = sdf.format(data);
        return dataAtual;
    }

    /**
     * Retorna a hora atual no formato HH:mm:ss
     * @return String no formato HH:MM:ss
     */
    public static String obterHoraAtual() {
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String horaAtual = sdf.format(data);
        return horaAtual;
    }

    /**
     * Retorna a hora do dia no momento da consulta.
     * Exemplo: Se a hora for 15:30:45, retorna 15
     * @return int
     */
    public static int obterHoraDia() {
        Date data = new Date();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(data);
        int horaDia = cal.get(GregorianCalendar.HOUR_OF_DAY);
        return horaDia;
    }

    /**
     * Retorna o DIA atual no formato EEE
     * @return String no formato EEE
     */
    public static String obterDiaAtual() {
        Date data = new Date();
        Locale BRAZIL = new Locale("pt", "BR");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", BRAZIL);
        String diaAtual = sdf.format(data);
        return diaAtual;
    }

    /**
     * Retorna o MES atual no formato E
     * @return String no formato E
     */
    public static String obterMesAtual() {
        Date data = new Date();
        Locale BRAZIL = new Locale("pt", "BR");
        SimpleDateFormat sdf = new SimpleDateFormat("M", BRAZIL);
        String mesAtual = sdf.format(data);
        return mesAtual;
    }


        /**
     * Retorna o MES atual no formato E de uma data passada como parametro
     * @return String no formato E
     */
    public static String obterMesAtualData(Date data) {
        Locale BRAZIL = new Locale("pt", "BR");
        SimpleDateFormat sdf = new SimpleDateFormat("M", BRAZIL);
        String mesAtual = sdf.format(data);
        return mesAtual;
    }
    /**
     * Retorna o MES atual no formato E
     * @return String no formato E
     */
    public static String obterAnoAtual() {
        Date data = new Date();
        Locale BRAZIL = new Locale("pt", "BR");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy", BRAZIL);
        String anoAtual = sdf.format(data);
        return anoAtual;
    }

    /**
     * Retorna o DIA semana recebendo uma string do formato data
     * @return String no formato EEE
     */
    public static String obterDiaSemana(String dataString) {
        Date data = retornarDate(dataString);
        Locale BRAZIL = new Locale("pt", "BR");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String diaSemana = sdf.format(data);
        return diaSemana;
    }


    public static String obterMesNumerico(String dataString) {
        String retorno = dataString;
        if (retorno.equalsIgnoreCase("Janeiro")) {
            retorno = "1";
        } else if (retorno.equalsIgnoreCase("Fevereiro")) {
            retorno = "2";
        } else if (retorno.equalsIgnoreCase("Março")) {
            retorno = "3";
        } else if (retorno.equalsIgnoreCase("Abril")) {
            retorno = "4";
        } else if (retorno.equalsIgnoreCase("Maio")) {
            retorno = "5";
        } else if (retorno.equalsIgnoreCase("Junho")) {
            retorno = "6";
        } else if (retorno.equalsIgnoreCase("Julho")) {
            retorno = "7";
        } else if (retorno.equalsIgnoreCase("Agosto")) {
            retorno = "8";
        } else if (retorno.equalsIgnoreCase("Setembro")) {
            retorno = "9";
        } else if (retorno.equalsIgnoreCase("Outubro")) {
            retorno = "10";
        } else if (retorno.equalsIgnoreCase("Novembro")) {
            retorno = "11";
        } else if (retorno.equalsIgnoreCase("Dezembro")) {
            retorno = "12";
        } else if (retorno.equalsIgnoreCase("Nenhum")) {
            retorno = "";
        }
        return retorno;
    }

    public static String obterMesExtenso(String dataString) {
        String retorno = dataString;
        if (retorno.equalsIgnoreCase("1")) {
            retorno = "Janeiro";
        } else if (retorno.equalsIgnoreCase("2")) {
            retorno = "Fevereiro";
        } else if (retorno.equalsIgnoreCase("3")) {
            retorno = "Março";
        } else if (retorno.equalsIgnoreCase("4")) {
            retorno = "Abril";
        } else if (retorno.equalsIgnoreCase("5")) {
            retorno = "Maio";
        } else if (retorno.equalsIgnoreCase("6")) {
            retorno = "Junho";
        } else if (retorno.equalsIgnoreCase("7")) {
            retorno = "Julho";
        } else if (retorno.equalsIgnoreCase("8")) {
            retorno = "Agosto";
        } else if (retorno.equalsIgnoreCase("9")) {
            retorno = "Setembro";
        } else if (retorno.equalsIgnoreCase("10")) {
            retorno = "Outubro";
        } else if (retorno.equalsIgnoreCase("11")) {
            retorno = "Novembro";
        } else if (retorno.equalsIgnoreCase("12")) {
            retorno = "Dezembro";
        } else if (retorno.equalsIgnoreCase("Nenhum")) {
            retorno = "";
        }
        return retorno;
    }

    /**
     * Verifica se duas datas são do mesmo dia.
     * Exemplo: data1 = 14/01/07 e data2 = 14/01/07 retorna true
     * @param data1 Date
     * @param data2 Date
     * @return boolean
     */
    public static boolean verificarDatasMesmoDia(Date data1, Date data2) {
        boolean retorno = false;

        try {
            GregorianCalendar cal1 = new GregorianCalendar();
            cal1.setTime(data1);

            if (data2 != null) {
                GregorianCalendar cal2 = new GregorianCalendar();
                cal2.setTime(data2);

                int dia1 = cal1.get(GregorianCalendar.DAY_OF_YEAR);
                int dia2 = cal2.get(GregorianCalendar.DAY_OF_YEAR);

                if (dia1 == dia2) {
                    retorno = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public static Long compararDatas(String data1, String data2) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date d1 = null;
        try {
            d1 = df.parse(data1);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Date d2 = null;
        try {
            d2 = df.parse(data2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        long dt = (d2.getTime() - d1.getTime()) + 3600000;
        long dias = (dt / 86400000L) + 1;

        return dias;
    }

    /**
     * Arredonda a hora de uma data.
     * Exemplo: data = 14/01/2007 15:30:47 retorna 15.
     * @param data Date
     * @return int
     */
    public static int arredondarHora(Date data) {

        int retorno = 0;

        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(data);
            int hora = cal.get(GregorianCalendar.HOUR_OF_DAY);
            retorno = hora;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    /**
     * Calcula a diferença em milisegundos entre duas datas.
     * @param dataInicio Date
     * @param dataFim Date
     * @return boolean
     */
    public static long calcularDiferencaTempoMilisegundos(Date dataInicio, Date dataFim) {

        long retorno = 0;

        if (dataInicio != null && dataFim != null) {
            long fim = dataFim.getTime();
            long inicio = dataInicio.getTime();
            retorno = fim - inicio;
        }

        return retorno;
    }

    /**
     * Calcula o tempo passado em milisegundos para minutos
     * @param milisegundos long
     * @return int tempo em minutos
     */
    public static int calcularTempoMinutos(long milisegundos) {

        int retorno = 0;

        retorno = (int) TimeUnit.MILLISECONDS.toMinutes(milisegundos);

        return retorno;
    }

    /**
     * Calcula o tempo passado em minutos para milisegundos
     * @param int tempo em minutos
     * @return milisegundos long
     */
    public static long calcularTempoMilisegundos(int minutos) {

        long retorno = 0;

        retorno = (int) TimeUnit.MINUTES.toMillis(minutos);

        return retorno;
    }

    /**
     * Calcula a soma em milisegundos entre duas datas.
     * @param dataInicio Date
     * @param dataFim Date
     * @return boolean
     */
    public static long calcularSomaTempoMilisegundos(Date dataInicio, Date dataFim) {

        long retorno = 0;

        long inicio = dataInicio.getTime();
        long fim = dataFim.getTime();
        retorno = fim + inicio;

        return retorno;
    }

    /**
     * Formata o tempo passado em milisegundos para HH:mm:ss
     * @param milisegundos long
     * @return String no formato dd/mm/yyyy
     */
    public static String formatarTempoHH_MM_SS(long milisegundos) {

        String tempoFormatado = "";

        int segundos = (int) milisegundos / 1000;
        if (milisegundos == 0) {
            tempoFormatado = "00:00:00";
        } else {
            int[] ret = new int[3];
            ret[0] = segundos / 3600;
            segundos = segundos % 3600;
            ret[1] = segundos / 60;
            segundos = segundos % 60;
            ret[2] = segundos;
            if (ret[0] != 0) {
                if (ret[0] < 10) {
                    tempoFormatado += "0" + ret[0] + ":";
                } else {
                    tempoFormatado += ret[0] + ":";
                }
            } else {
                tempoFormatado += "00:";
            }
            if (ret[1] != 0) {
                if (ret[1] < 10) {
                    tempoFormatado += "0" + ret[1] + ":";
                } else {
                    tempoFormatado += ret[1] + ":";
                }
            } else {
                tempoFormatado += "00:";
            }
            if (ret[2] != 0) {
                if (ret[2] < 10) {
                    tempoFormatado += "0" + ret[2];
                } else {
                    tempoFormatado += ret[2];
                }
            } else {
                tempoFormatado += "00";
            }
        }

        return tempoFormatado;
    }

    /**
     * Retorna uma String representando uma data no formato dd/MM/yyyy
     * @param data Date
     * @return String (formato dd/MM/yyyy)
     */
    public static String formatarDataDDMMYYYY(Date data) {

        String retorno = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        retorno = sdf.format(data);
        return retorno;
    }

    /**
     * Retorna uma String representando uma data no formato yyyy-MM-dd HH:mm:ss.SSS
     * @param data Date
     * @return String (formato yyyy-MM-dd HH:mm:ss.SSS)
     */
    public static String formatarDataYYYYMMDD_HHmmss(Date data) {

        String retorno = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        retorno = sdf.format(data);
        return retorno;
    }

    /**
     * Retorna uma String representando uma data no formato yyyy-MM-dd HH:mm:ss.SSS
     * @param data Date
     * @return String (formato yyyy-MM-dd HH:mm:ss.SSS)
     */
    public static String formatarDataDDMMYYYY_HHmmss(Date data) {

        String retorno = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        retorno = sdf.format(data);
        return retorno;
    }

    /**
     * Retorna uma String representando um horário no formato HH:mm:ss
     * @param data Date
     * @return String (formato HH:mm:ss)
     */
    public static String formatarHoraHH_mm_ss(Date data) {

        String retorno = "";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        retorno = sdf.format(data);
        return retorno;
    }

    public static String formatarMesAno() {
        Date data = new Date();
        String retorno = "";
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM/yyyy");
        retorno = sdf.format(data);
        return retorno;
    }

    /**
     * Retorna o início do dia de uma data.
     * Obs: Método utilizado para createNativeQuery()
     * Exemplo: data = 14/01/2007 retorna 20070114 00:00:00.000
     * @param data String (formato dd/MM/yyyy)
     * @return String (formato yyyyMMdd 00:00:00.000)
     */
    public static String getDataInicioDiaYYYYMMDD(String data) {

        String retorno = "";

        retorno = retorno.concat(data.substring(6, 10));
        retorno = retorno.concat(data.substring(3, 5));
        retorno = retorno.concat(data.substring(0, 2));
        retorno = retorno.concat(" 00:00:00.000");

        return retorno;
    }

    /**
     * Retorna o início do dia de uma data.
     * Obs: Método utilizado para createQuery()
     * Exemplo: data = 14/01/2007 retorna 2007-01-14 00:00:00.000
     * @param data String (formato dd/MM/yyyy)
     * @return String (formato yyyy-MM-dd 00:00:00.000)
     */
    public static String getDataInicioDiaYYYY_MM_DD(String data) {

        String retorno = "";

        retorno = retorno.concat(data.substring(6, 10));
        retorno = retorno.concat("-");
        retorno = retorno.concat(data.substring(3, 5));
        retorno = retorno.concat("-");
        retorno = retorno.concat(data.substring(0, 2));
        retorno = retorno.concat(" 00:00:00.000");

        return retorno;
    }

    /**
     * Retorna o fim do dia de uma data.
     * Obs: Método utilizado para createNativeQuery()
     * Exemplo: data = 14/01/2007 retorna 20070114 23:59:59.999
     * @param data String (formato dd/MM/yyyy)
     * @return String (formato yyyyMMdd 23:59:59.999)
     */
    public static String getDataFimDiaYYYYMMDD(String data) {

        String retorno = "";

        retorno = retorno.concat(data.substring(6, 10));
        retorno = retorno.concat(data.substring(3, 5));
        retorno = retorno.concat(data.substring(0, 2));
        retorno = retorno.concat(" 23:59:59.999");

        return retorno;
    }

    /**
     * Retorna o fim do dia de uma data.
     * Obs: Método utilizado para createQuery()
     * Exemplo: data = 14/01/2007 retorna 20070114 23:59:59.999
     * @param data String (formato dd/MM/yyyy)
     * @return String (formato yyyy-MM-dd 23:59:59.999)
     */
    public static String getDataFimDiaYYYY_MM_DD(String data) {

        String retorno = "";

        retorno = retorno.concat(data.substring(6, 10));
        retorno = retorno.concat("-");
        retorno = retorno.concat(data.substring(3, 5));
        retorno = retorno.concat("-");
        retorno = retorno.concat(data.substring(0, 2));
        retorno = retorno.concat(" 23:59:59.999");

        return retorno;
    }

    /**
     * Retorna a data atual.
     * @return Date (formato yyyy-MM-dd HH:mm:ss.000)
     */
    public static Date retornarDataAtual() {
        Date retorno = null;

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date());
        gc.set(GregorianCalendar.MILLISECOND, 0);
        retorno = gc.getTime();

        return retorno;
    }

    /**
     * Retorna a data atual sem milisegundos.
     * @return Date (formato yyyy-MM-dd HH:mm:00.000)
     */
    public static Date retornarDataAtualSemSegundos() {
        Date retorno = null;

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date());
        gc.set(GregorianCalendar.MILLISECOND, 0);
        gc.set(GregorianCalendar.SECOND, 0);
        retorno = gc.getTime();

        return retorno;
    }

    /**
     * Retorna um Date a partir de uma String no formato dd/MM/yyyy
     * @param data String no formato dd/MM/yyyy
     * @return Date
     */
    public static Date retornarDate(String data) {
        Date retorno = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            retorno = sdf.parse(data);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }

    /**
     * Retorna um Date a partir de uma String no formato dd/nomemes/yyyy
     * @param data String no formato dd/nomemes/yyyy
     * @return Date
     */
    public static Date retornarDateExtenso(String data) {
        Date retorno = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            retorno = sdf.parse(data);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }

    /**
     *  Concatenar a Data Atual com a hora informada
     *  @param string da hora no formato hh:mm:ss
     *  @return Date
     */
    public static Date retornarHoraComDataAtual(String hora) {

        Date retorno = null;
        Date agora = new Date();

        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = sdfData.format(agora);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            retorno = sdf.parse(dataHoje + " " + hora);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }

    /**
     *  Concatenar a data Informada com a hora informada
     *  @param dataBase e horaBase no formato Date
     *  @return Date
     */
    public static Date concatenaDataComHora(Date dataBase, Date horaBase) {

        Date retorno = null;

        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String dataPadrao = sdfData.format(dataBase);

        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
        String horaParametro = sdfHora.format(horaBase);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            retorno = sdf.parse(dataPadrao + " " + horaParametro);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }

    /**
     * Retorna uma data posterior a uma data passada como referência.
     * @param dtParametro Date (data de referência)
     * @param dias int (número de dias)
     * @return Date
     */
    public static Date retornarDataPosterior(Date dtParametro, int dias) {
        Date retorno = null;

        GregorianCalendar calParametro = new GregorianCalendar();
        calParametro.setTime(dtParametro);
        calParametro.add(calParametro.DATE, dias);
        retorno = calParametro.getTime();

        /*GregorianCalendar calPosterior = new GregorianCalendar();
        calPosterior.add(calParametro.DATE, 1);
        retorno =  calPosterior.getTime();*/

        return retorno;
    }

    /**
     * Retorna uma data no final do dia.
     * @param data Date (data recebida como parâmetro no formato dd/MM/yyyy 00:00:00)
     * @return Date (data no formato 23:59:59)
     */
    public static Date retornarDataFinalDia(Date data) {
        Date retorno = null;

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(data);
        cal.add(cal.HOUR, 23);
        cal.add(cal.MINUTE, 59);
        cal.add(cal.SECOND, 59);
        retorno = cal.getTime();

        return retorno;
    }

    /**
     * Retorna uma data no início do dia.
     * @param data Date (data recebida como parâmetro no formato dd/MM/yyyy 00:00:00)
     * @return Date (data no formato 00:00:00)
     */
    public static Date retornarDataInicioDia(Date data) {
        Date retorno = null;

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(data);
        cal.add(cal.HOUR, 00);
        cal.add(cal.MINUTE, 00);
        cal.add(cal.SECOND, 00);
        retorno = cal.getTime();

        return retorno;
    }

    /**
     * Retorna uma data no final do dia.
     * @param data Date (data recebida como parâmetro no formato dd/MM/yyyy 00:00:00)
     * @return Date (data no formato 12:00:00)
     */
    public static Date retornarDataMeioDia(Date data) {
        Date retorno = null;

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(data);
        cal.add(cal.HOUR, 12);
        cal.add(cal.MINUTE, 0);
        cal.add(cal.SECOND, 0);
        retorno = cal.getTime();

        return retorno;
    }

    /**
     * Verifica se a hora está atrasada entre data1 e data2.
     * Exemplo: data1 = 14/01/07 08:00:00.000 e data2 = 14/01/07 08:30:00.000 retorna true
     * ou ainda 14/01/07 08:00:00.000 e data2 = 20/01/07 07:30:00.000 retorna false
     * @param data1 Date
     * @param data2 Date
     * @return boolean
     */
    public static boolean verificarHoraAtrasada(Date data1, Date data2) {
        boolean retorno = false;

        try {
            if (retornarHoraComDataAtual(formatarHoraHH_mm_ss(data1)).before(retornarHoraComDataAtual(formatarHoraHH_mm_ss(data2)))) {
                retorno = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    /**
     * Verifica se hora final e menor que hora inicial.
     * Exemplo: horaInicial = 08:00:00 e horaFinal = 07:00:00 retorna false
     * @param horaInicial String
     * @param horaFinal String
     * @return boolean
     */
    public static boolean verificarHoraFinalMenorDataInicial(String horaInicial, String horaFinal) {
        boolean retorno = true;

        Date data1 = retornarHoraComDataAtual(horaInicial);
        Date data2 = retornarHoraComDataAtual(horaFinal);
        long data1_milisegundos = data1.getTime();
        long data2_milisegundos = data2.getTime();

        try {

            if (data1_milisegundos >= data2_milisegundos) {
                retorno = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public static Date adicionarMinutosNaData(Date dtParametro, int minutos) {
        Date retorno = null;

        GregorianCalendar calParametro = new GregorianCalendar();
        calParametro.setTime(dtParametro);
        calParametro.add(calParametro.MINUTE, minutos);
        retorno = calParametro.getTime();

        return retorno;
    }

    public static List<Date> montarPeriodo(String dataInicial, String dataFinal) {
        List<Date> retorno = new ArrayList();

        Date dataComeco = retornarDataInicioDia(retornarDate(dataInicial));
        Date dataFim = retornarDataFinalDia(retornarDate(dataFinal));

        retorno.add(dataComeco);

        int dias = calculaDiferencaDias(dataComeco, dataFim);

        for (int i = 0; i < dias; i++) {
            Date date = retorno.get(i);
            retorno.add(retornarDataPosterior(date, 1));
        }

        return retorno;
    }

    public static int calculaDiferencaDias(Date dataInicial, Date dataFinal) {
        GregorianCalendar dataInicio = new GregorianCalendar();
        GregorianCalendar dataFim = new GregorianCalendar();
        dataInicio.setTime(dataInicial);
        dataFim.setTime(dataFinal);

        int dias = dataFim.get(GregorianCalendar.DAY_OF_MONTH) - dataInicio.get(GregorianCalendar.DAY_OF_MONTH);

        return dias;
    }
}
