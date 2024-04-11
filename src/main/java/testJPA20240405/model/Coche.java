package testJPA20240405.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coche")
public class Coche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "idFabricante")
	private int idFabricante;
	private String bastidor;
	private String modelo;
	private String color;
	
	
	public Coche() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdFabricante() {
		return idFabricante;
	}


	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}


	public String getBastidor() {
		return bastidor;
	}


	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	
	

}
