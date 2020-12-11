package br.com.globalcode.aj3.datas;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import static java.util.Calendar.*;
import static java.text.DateFormat.*;

/**
 * Classe que realiza a formatacao de datas
 * 
 * @author Globalcode
 */
public class FormataDatas {

	public static void main(String[] args) {

		// b) Criacao do objeto Calendar
		Calendar cal = Calendar.getInstance();

		// c) Alteracao dos dados do calendario para
		// 03 de março de 1997, as 18h57m0s
		cal.set(DAY_OF_MONTH, 3);
		cal.set(MONTH, MARCH);
		cal.set(YEAR, 1997);
		
		cal.set(HOUR_OF_DAY, 18);
		cal.set(MINUTE, 57);
		cal.set(SECOND, 0);

		// d) Obtencao do Date a partir do Calendar
		Date data = cal.getTime();
		System.out.println("data: " + data);

		// e) Construcao do objeto para formatacao especifica
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yy HH'h'mm'm'ss");
		System.out.println("data formatada com SimpleDateFormat: "
				+ formatador.format(data));
		System.out.println("data atual formatada com SimpleDateFormat: "
				+ formatador.format(new Date()));

		// f) Construcao do objeto para formatacao padrao
		DateFormat formatador2 = getDateInstance(MEDIUM);
		System.out.println("data formatada com DateFormat: "
				+ formatador2.format(data));
		System.out.println("data atual formatada com DateFormat: "
				+ formatador.format(new Date()));

	}
}
