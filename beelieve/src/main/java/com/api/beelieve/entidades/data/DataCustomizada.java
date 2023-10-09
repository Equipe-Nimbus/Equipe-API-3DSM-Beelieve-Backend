package com.api.beelieve.entidades.data;





import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Table(name = "data_customizada")
@Entity
@ToString
public class DataCustomizada {
	
	@Id
	private Long id;
	
	@Column
	private Date data;
	
	public DataCustomizada() {}
	
	public DataCustomizada(Date data) {
		this.data = data;
		this.id = Long.valueOf(1);
	}
}
