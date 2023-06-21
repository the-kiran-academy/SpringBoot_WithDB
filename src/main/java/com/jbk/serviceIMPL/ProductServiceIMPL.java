package com.jbk.serviceIMPL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Category;
import com.jbk.entity.Product;
import com.jbk.entity.Supplier;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public Boolean addProduct(Product product) {

		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		product.setProductId(Long.parseLong(id));
		return dao.addProduct(product);
	}

	@Override
	public Product getProductById(Long id) {
		return dao.getProductById(id);
	}

	@Override
	public Product getProductByName(String getProductByName) {
		return dao.getProductByName(getProductByName);
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public Boolean deleteProduct(Long id) {
		return dao.deleteProduct(id);
	}

	@Override
	public Boolean updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public List<Product> sortProducts(String sortBy, String fieldName) {
		return dao.sortProducts(sortBy, fieldName);
	}

	@Override
	public List<Product> getMaxPriceProducts() {
		return dao.getMaxPriceProducts();
	}

	@Override
	public Double countSumOfProductPrice() {

		double sumOfProductPrice = dao.countSumOfProductPrice();

		String formattedNumber = String.format("%.3f", sumOfProductPrice);
		System.out.println(formattedNumber);

		return Double.parseDouble(formattedNumber);

	}

	@Override
	public Long getTotalCountOfProducts() {

		return dao.getTotalCountOfProducts();
	}

	public List<Product> readExcel(String filePath) {
List<Product> list=new ArrayList<Product>();
		try {

			// FileInputStream fileInputStream=new FileInputStream(filePath);

			// Workbook workbook=new XSSFWorkbook(fileInputStream);

			Workbook workbook = new XSSFWorkbook(filePath);

			Sheet sheet = workbook.getSheet("product");

			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				Row row = (Row) rows.next();
				// exclude header row
				if (row.getRowNum() == 0) {
					continue;
				}

				Product product = new Product();
				String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
				product.setProductId(Long.parseLong(id));

				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = (Cell) cells.next();

					int columnIndex = cell.getColumnIndex();

					switch (columnIndex) {
					case 0: {
						product.setProductName(cell.getStringCellValue());
						break;
					}

					case 1: {
						Supplier supplier = new Supplier();
						supplier.setSupplierId((long) cell.getNumericCellValue());
						product.setSupplierId(supplier);
						break;
					}

					case 2: {
						Category category = new Category();
						category.setCategoryId((long) cell.getNumericCellValue());
						product.setCategoryId(category);
						break;
					}

					case 3: {
						product.setProductQTY((int) cell.getNumericCellValue());

						break;
					}
					case 4: {
						product.setProductPrice(cell.getNumericCellValue());

						break;
					}

					}

				}
				list.add(product);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public String uploadSheet(MultipartFile file) {
		String path = "src/main/resources/";
		String name = file.getOriginalFilename();
		String msg=null;
		try {

			FileOutputStream fos = new FileOutputStream(path + File.separator + name);

			byte[] data = file.getBytes();
			fos.write(data);

			List<Product> list = readExcel(path + File.separator + name);
			
			for (Product product : list) {
				System.out.println(product);
			}
			
		//msg=	dao.uploadSheet(list);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

}
