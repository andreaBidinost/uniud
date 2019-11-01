package uniud.lombok;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
@Log
public class Quadro {
	private Persona pittore;
	private Date dataCompletamento;
	private Date dataPrimaEsposizione;
	private Stili stile;
	private Double quotazione;
	private String proprietario;
	private Tele materialeTela;
	
	
}
