package vn.ifisolution.fresher12.IOT_CTHV.entities;

import java.util.Date;

public class Meter {
	private String code;
	private String name;
	private boolean status;
	private String unit;
	private String meterType;
	private Float PCI;
	private Float PCS;
	private Date startDate;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMeterType() {
		return meterType;
	}
	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}
	public Float getPCI() {
		return PCI;
	}
	public void setPCI(Float pCI) {
		PCI = pCI;
	}
	public Float getPCS() {
		return PCS;
	}
	public void setPCS(Float pCS) {
		PCS = pCS;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Meter(String code, String name, boolean status, String unit, String meterType, Float pCI, Float pCS,
			Date startDate) {
		super();
		this.code = code;
		this.name = name;
		this.status = status;
		this.unit = unit;
		this.meterType = meterType;
		PCI = pCI;
		PCS = pCS;
		this.startDate = startDate;
	}
	public Meter() {
		super();
	}
	
	
}

//Object	Field	Field Type	Value	Read-only	Can be empty
//Meter	Code	Text			No
//Meter	Name	Text			No
//Meter	Status	Checkbox	"0: Inactive
//1: Active"		No
//Meter	Unit	Select	"00: MWh
//01: kWh
//03: m3
//04: Tonne
//05: Kg"		No
//Meter	Meter Type	Checkbox	"0: Real
//1: Virtual"		No
//Meter	PCI conversion coefficient	Float			
//Meter	PCS conversion coefficient	Float			
//Meter	Start Date			Yes	No

