package du.tech.baccarat.domain.game;

import java.io.Serializable;

import javax.persistence.Column;

public class GameKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public GameKey() {
		super();
	}

	public GameKey(int gameSet, int gameNo) {
		super();
		this.gameSet = gameSet;
		this.gameNo = gameNo;
	}

	@Column(name = "GAMESET", nullable = false)
    private int gameSet;

    @Column(name = "GAMENO", nullable = false)
    private int gameNo;

    //------------------------------------------Getters and Setters------------------------------------------------
	public int getGameSet() {
		return gameSet;
	}

	public void setGameSet(int gameSet) {
		this.gameSet = gameSet;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
    
}
