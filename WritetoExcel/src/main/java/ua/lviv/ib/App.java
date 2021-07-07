package ua.lviv.ib;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mitateknik.gateway.bom.AggregationTypeEnum;
import com.mitateknik.gateway.bom.DataClassValueTypeEnum;
import com.mitateknik.gateway.bom.DataTypeEnum;
import com.mitateknik.gateway.bom.IEECDataTypeEnum;
import com.mitateknik.gateway.bom.MeasureFactorEnum;
import com.mitateknik.gateway.bom.MeasureUnitEnum;
import com.mitateknik.util.bom.MeasurementUnitConvertor;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		if (args.length != 1) {
			throw new IllegalArgumentException("Must be one argument (Table name)");
		}

		String Select = "Select * from LIVEDATATAB where name = '" + args[0] + "'";

		Connection conn = ConnectionUtils.openConnection();

		Statement statement = conn.createStatement();

		ResultSet res = statement.executeQuery(Select);

		List<Integer> list = new ArrayList<>();
		List<Table> listTable = new ArrayList<>();
		List<Integer> listDataclassid = new ArrayList<>();

		while (res.next()) {
			int id = res.getInt("id");
			list.add(id);

		}

		res.close();

		PreparedStatement statement2 = conn.prepareStatement(
				"Select id, dataclassid, enabled, name, minvalue, maxvalue, aggregation, precision, unit, factor, outputdataclassid, INCLUDEINTO10MINAVERAGELOG, INCLUDEINTO1MINAVERAGELOG, INCLUDEINTOHIGHRESOLUTIONLOG, [GROUP] from LIVEDATATABITEM where tabid = ?");
		statement2.setLong(1, list.get(0));

		ResultSet res2 = statement2.executeQuery();

		while (res2.next()) {
			int newid = res2.getInt("id");
			int dataclassid = res2.getInt("dataclassid");
			listDataclassid.add(dataclassid);
			int enabled = res2.getInt("enabled");
			String name = res2.getString("name");
			int minvalue = res2.getInt("minvalue");
			int maxvalue = res2.getInt("maxvalue");
			int aggregation = res2.getInt("aggregation");
			int precision = res2.getInt("precision");
			int unit = res2.getInt("unit");
			int factor = res2.getInt("factor");
			int outputdataclassid = res2.getInt("outputdataclassid");
			int INCLUDEINTO10MINAVERAGELOG = res2.getInt("INCLUDEINTO10MINAVERAGELOG");
			int INCLUDEINTO1MINAVERAGELOG = res2.getInt("INCLUDEINTO1MINAVERAGELOG");
			int INCLUDEINTOHIGHRESOLUTIONLOG = res2.getInt("INCLUDEINTOHIGHRESOLUTIONLOG");
			String GROUP = res2.getString("GROUP");
			Table table = new Table(newid, dataclassid, enabled, name, minvalue, maxvalue, aggregation, precision, unit,
					factor, outputdataclassid, INCLUDEINTO10MINAVERAGELOG, INCLUDEINTO1MINAVERAGELOG,
					INCLUDEINTOHIGHRESOLUTIONLOG, GROUP);
			listTable.add(table);

		}

		res2.close();

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(args[0]);

		Row firstrow = sheet.createRow(0);
		firstrow.createCell(0).setCellValue("Id");
		firstrow.createCell(1).setCellValue("Dataclassid");
		firstrow.createCell(2).setCellValue("Enabled");
		firstrow.createCell(3).setCellValue("Name");
		firstrow.createCell(4).setCellValue("Minvalue");
		firstrow.createCell(5).setCellValue("Maxvalue");
		firstrow.createCell(6).setCellValue("Aggregation");
		firstrow.createCell(7).setCellValue("Precision");
		firstrow.createCell(8).setCellValue("Unit/Factor");
		firstrow.createCell(9).setCellValue("Outputdataclassid");
		firstrow.createCell(10).setCellValue("INCLUDEINTO10MINAVERAGELOG");
		firstrow.createCell(11).setCellValue("INCLUDEINTO1MINAVERAGELOG");
		firstrow.createCell(12).setCellValue("INCLUDEINTOHIGHRESOLUTIONLOG");
		firstrow.createCell(13).setCellValue("GROUP");

		int rowNum = 1;
		for (Table table : listTable) {
			Row row = sheet.createRow(rowNum);

			row.createCell(0).setCellValue(table.getId());
			row.createCell(1).setCellValue(table.getDataclassid());
			row.createCell(2).setCellValue(table.getEnabled());
			row.createCell(3).setCellValue(table.getName());
			row.createCell(4).setCellValue(table.getMinvalue());
			row.createCell(5).setCellValue(table.getMaxvalue());

			if (table.getAggregation() != 0)
				row.createCell(6).setCellValue(AggregationTypeEnum.from_int(table.getAggregation()).name());
			row.createCell(7).setCellValue(table.getPrecision());

			MeasureUnitEnum unit = null;
			MeasureFactorEnum factor = null;

			if (table.getUnit() != 0)
				unit = MeasureUnitEnum.from_int(table.getUnit());

			if (table.getFactor() != 0)
				factor = MeasureFactorEnum.from_int(table.getFactor());

			row.createCell(8).setCellValue(MeasurementUnitConvertor.toString(unit, factor));
			row.createCell(9).setCellValue(table.getOutputdataclassid());
			row.createCell(10).setCellValue(table.getINCLUDEINTO10MINAVERAGELOG());
			row.createCell(11).setCellValue(table.getINCLUDEINTO1MINAVERAGELOG());
			row.createCell(12).setCellValue(table.getINCLUDEINTOHIGHRESOLUTIONLOG());
			row.createCell(13).setCellValue(table.getGROUP());
			rowNum++;

		}

		PreparedStatement statement3 = conn.prepareStatement("Select * from DATACLASS where id = ?");
		sheet = workbook.createSheet("DATACLASS");

		Row rowfirst = sheet.createRow(0);
		rowfirst.createCell(0).setCellValue("id");
		rowfirst.createCell(1).setCellValue("name");
		rowfirst.createCell(2).setCellValue("measureunit");
		rowfirst.createCell(3).setCellValue("description");
		rowfirst.createCell(4).setCellValue("minvalue");
		rowfirst.createCell(5).setCellValue("maxvalue");
		rowfirst.createCell(6).setCellValue("datatype");
		rowfirst.createCell(7).setCellValue("parentid");
		rowfirst.createCell(8).setCellValue("valuetype");
		rowfirst.createCell(9).setCellValue("itemtype");
		rowfirst.createCell(10).setCellValue("ieecdatatype");

		int newRow = 1;

		for (int i = 0; i < listDataclassid.size(); i++) {
			statement3.setLong(1, listDataclassid.get(i));
			ResultSet res3 = statement3.executeQuery();

			while (res3.next()) {
				int id2 = res3.getInt("id");
				String name = res3.getString("name");
				int measureunit = res3.getInt("measureunit");
				String description = res3.getString("description");
				int minvalue = res3.getInt("minvalue");
				int maxvalue = res3.getInt("maxvalue");
				int datatype = res3.getInt("datatype");
				int parentid = res3.getInt("parentid");
				int valuetype = res3.getInt("valuetype");
				int itemtype = res3.getInt("itemtype");
				int ieecdatatype = res3.getInt("ieecdatatype");
				Table2 table2 = new Table2(id2, name, measureunit, description, minvalue, maxvalue, datatype, parentid,
						valuetype, itemtype, ieecdatatype);

				Row row = sheet.createRow(newRow);
				row.createCell(0).setCellValue(table2.getId());
				row.createCell(1).setCellValue(table2.getName());
				MeasureUnitEnum newmeasureunit = MeasureUnitEnum.from_int(table2.getMeasureunit());
				row.createCell(2).setCellValue(MeasurementUnitConvertor.getUnitName(newmeasureunit));
				row.createCell(3).setCellValue(table2.getDescription());
				row.createCell(4).setCellValue(table2.getMinvalue());
				row.createCell(5).setCellValue(table2.getMaxvalue());
				if (table2.getDatatype() != 0)
					row.createCell(6).setCellValue(DataTypeEnum.from_int(table2.getDatatype()).name());
				row.createCell(7).setCellValue(table2.getParentid());
				if (table2.getValuetype() != 0)
					row.createCell(8).setCellValue(DataClassValueTypeEnum.from_int(table2.getValuetype()).name());
				row.createCell(9).setCellValue(table2.getItemtype());
				if (table2.getIeecdatatype() != 0)
					row.createCell(10).setCellValue(IEECDataTypeEnum.from_int(table2.getIeecdatatype()).name());

			}
			newRow++;
			res3.close();
		}

		FileOutputStream fileOut = new FileOutputStream(args[0] + ".xlsx");
		workbook.write(fileOut);
		fileOut.close();

		workbook.close();

		// select id, dataclassid, enabled, name, minvalue, maxvalue, aggregation,
		// precision, unit, factor, outputdataclassid,
		// INCLUDEINTO10MINAVERAGELOG, INCLUDEINTO1MINAVERAGELOG,
		// INCLUDEINTOHIGHRESOLUTIONLOG, [GROUP]
		// from LIVEDATATABITEM
		// https://www.callicoder.com/java-write-excel-file-apache-poi/
	}

}
