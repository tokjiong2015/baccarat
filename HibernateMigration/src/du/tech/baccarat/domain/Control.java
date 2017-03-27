package du.tech.baccarat.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Control", schema = "baccarat")
public class Control {

	public Control(String controlCode) {
		super();
		this.controlCode = controlCode;
	}

	@Id @Column(name="COTL_CODE", nullable=false, length=1)
	private String controlCode;
	
	@Column(name="COTL_VALUE", nullable=false, length=10)
	private String controlValue;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "LUP_TIME")
	private Date lup_time;

	public String getControlCode() {
		return controlCode;
	}

	public void setControlCode(String controlCode) {
		this.controlCode = controlCode;
	}

	public String getControlValue() {
		return controlValue;
	}

	public void setControlValue(String controlValue) {
		this.controlValue = controlValue;
	}

	public Date getLup_time() {
		return lup_time;
	}

	public void setLup_time(Date lup_time) {
		this.lup_time = lup_time;
	}

}
