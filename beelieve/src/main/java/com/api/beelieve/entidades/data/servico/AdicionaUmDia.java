package com.api.beelieve.entidades.data.servico;

import java.util.Date;
import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class AdicionaUmDia {

	public Date adicionaDia(Date data) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		calendario.add(Calendar.DAY_OF_MONTH, 1);
		return calendario.getTime();
	}
}
