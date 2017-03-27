package du.tech.baccarat.key;

import java.io.Serializable;

import javax.persistence.Column;

public class GameKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public GameKey(int gameSet, int gameNo) {
		super();
		this.gameSet = gameSet;
		this.gameNo = gameNo;
	}

	@Column(name = "GAMESET", nullable = false)
    private int gameSet;

    @Column(name = "GAMENO", nullable = false)
    private int gameNo;

}
