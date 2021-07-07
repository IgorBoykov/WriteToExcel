package ua.lviv.ib;

public class Table2 {

	private int id;
	private String name;
	private int measureunit;
	private String description;
	private int minvalue;
	private int maxvalue;
	private int datatype;
	private int parentid;
	private int valuetype;
	private int itemtype;
	private int ieecdatatype;

	public Table2(int id, String name, int measureunit, String description, int minvalue, int maxvalue, int datatype,
			int parentid, int valuetype, int itemtype, int ieecdatatype) {
		super();
		this.id = id;
		this.name = name;
		this.measureunit = measureunit;
		this.description = description;
		this.minvalue = minvalue;
		this.maxvalue = maxvalue;
		this.datatype = datatype;
		this.parentid = parentid;
		this.valuetype = valuetype;
		this.itemtype = itemtype;
		this.ieecdatatype = ieecdatatype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMeasureunit() {
		return measureunit;
	}

	public void setMeasureunit(int measureunit) {
		this.measureunit = measureunit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getDatatype() {
		return datatype;
	}

	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public int getValuetype() {
		return valuetype;
	}

	public void setValuetype(int valuetype) {
		this.valuetype = valuetype;
	}

	public int getItemtype() {
		return itemtype;
	}

	public void setItemtype(int itemtype) {
		this.itemtype = itemtype;
	}

	public int getIeecdatatype() {
		return ieecdatatype;
	}

	public void setIeecdatatype(int ieecdatatype) {
		this.ieecdatatype = ieecdatatype;
	}

}
