package com.jbk.daoIMPL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean saveProduct(Product product) {
		boolean isAdded = false;
		Session session = null;
		try {
			session = factory.openSession();

			session.save(product);
			session.beginTransaction().commit();
			isAdded = true;

		}

		catch (Exception e) {
			e.printStackTrace();
			isAdded = false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public Product getProductById(String productId) {
		Session session = null;
		Product product=null;
		try {
			session = factory.openSession();
			product=session.get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;

	}

	@Override
	public List<Product> getAllProduct() {
		return null;

	}

	@Override
	public boolean deleteProductById(String productId) {

		return false;
	}

	@Override
	public boolean updateProduct(Product product) {

		return false;
	}

}
