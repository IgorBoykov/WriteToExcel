package ua.lviv.ib;

public class Table {

	private int id;
	private int dataclassid;
	private int enabled;
	private String name;
	private int minvalue;
	private int maxvalue;
	private int aggregation;
	private int precision;
	private int unit;
	private int factor;
	private int outputdataclassid;
	private int INCLUDEINTO10MINAVERAGELOG;
	private int INCLUDEINTO1MINAVERAGELOG;
	private int INCLUDEINTOHIGHRESOLUTIONLOG;
	private String GROUP;

	public Table(int id, int dataclassid, int enabled, String name, int minvalue, int maxvalue, int aggregation,
			int precision, int unit, int factor, int outputdataclassid, int iNCLUDEINTO10MINAVERAGELOG,
			int iNCLUDEINTO1MINAVERAGELOG, int iNCLUDEINTOHIGHRESOLUTIONLOG, String gROUP) {
		super();
		this.id = id;
		this.dataclassid = dataclassid;
		this.enabled = enabled;
		this.name = name;
		this.minvalue = minvalue;
		this.maxvalue = maxvalue;
		this.aggregation = aggregation;
		this.precision = precision;
		this.unit = unit;
		this.factor = factor;
		this.outputdataclassid = outputdataclassid;
		INCLUDEINTO10MINAVERAGELOG = iNCLUDEINTO10MINAVERAGELOG;
		INCLUDEINTO1MINAVERAGELOG = iNCLUDEINTO1MINAVERAGELOG;
		INCLUDEINTOHIGHRESOLUTIONLOG = iNCLUDEINTOHIGHRESOLUTIONLOG;
		GROUP = gROUP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDataclassid() {
		return dataclassid;
	}

	public void setDataclassid(int dataclassid) {
		this.dataclassid = dataclassid;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinvalue() {
		return minvalue;
	}

	public void setMinvalue(int minvalue) {
		this.minvalue = minvalue;
	}

	public int getMaxvalue() {
		return maxvalue;
	}

	public void setMaxvalue(int maxvalue) {
		this.maxvalue = maxvalue;
	}

	public int getAggregation() {
		return aggregation;
	}

	public void setAggregation(int aggregation) {
		this.aggregation = aggregation;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}

	public int getOutputdataclassid() {
		return outputdataclassid;
	}

	public void setOutputdataclassid(int outputdataclassid) {
		this.outputdataclassid = outputdataclassid;
	}

	public int getINCLUDEINTO10MINAVERAGELOG() {
		return INCLUDEINTO10MINAVERAGELOG;
	}

	public void setINCLUDEINTO10MINAVERAGELOG(int iNCLUDEINTO10MINAVERAGELOG) {
		INCLUDEINTO10MINAVERAGELOG = iNCLUDEINTO10MINAVERAGELOG;
	}

	public int getINCLUDEINTO1MINAVERAGELOG() {
		return INCLUDEINTO1MINAVERAGELOG;
	}

	public void setINCLUDEINTO1MINAVERAGELOG(int iNCLUDEINTO1MINAVERAGELOG) {
		INCLUDEINTO1MINAVERAGELOG = iNCLUDEINTO1MINAVERAGELOG;
	}

	public int getINCLUDEINTOHIGHRESOLUTIONLOG() {
		return INCLUDEINTOHIGHRESOLUTIONLOG;
	}

	public void setINCLUDEINTOHIGHRESOLUTIONLOG(int iNCLUDEINTOHIGHRESOLUTIONLOG) {
		INCLUDEINTOHIGHRESOLUTIONLOG = iNCLUDEINTOHIGHRESOLUTIONLOG;
	}

	public String getGROUP() {
		return GROUP;
	}

	public void setGROUP(String gROUP) {
		GROUP = gROUP;
	}

}
