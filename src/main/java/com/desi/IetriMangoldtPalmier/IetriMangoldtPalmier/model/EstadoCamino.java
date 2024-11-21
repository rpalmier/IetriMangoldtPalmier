package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model;
import jakarta.persistence.*;

@Entity
@Table(name = "estadocamino")
public class EstadoCamino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer idEstado;

    @ManyToOne
    @JoinColumn(name = "id_camino", nullable = false)
    private Camino camino;

    @Column(name = "estado_camino", length = 50)
    private String estadoCamino;

    @Column(name = "estado_clima", length = 50)
    private String estadoClima;
    
    // Getters y setters

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Camino getCamino() {
		return camino;
	}

	public void setCamino(Camino camino) {
		this.camino = camino;
	}

	public String getEstadoCamino() {
		return estadoCamino;
	}

	public void setEstadoCamino(String estadoCamino) {
		this.estadoCamino = estadoCamino;
	}

	public String getEstadoClima() {
		return estadoClima;
	}

	public void setEstadoClima(String estadoClima) {
		this.estadoClima = estadoClima;
	}
    
     
   
}