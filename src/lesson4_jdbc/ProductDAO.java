/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson4_jdbc;

import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class ProductDAO extends ICommon<Product>{
    DbUtil db;
    @Override
    public Product[] selectAll() {
        Vector<Product> temp = new Vector<Product>();
        String sql = "select ProductId, ProductName, UnitPrice, UnitsInStock from products; ";
        try {
            db = new DbUtil();
            db.openConnection();
            statement = db.conn.createStatement();
            resultSet =  statement.executeQuery(sql);
            while(resultSet.next()){
                temp.add(new Product(resultSet.getInt(1), resultSet.getString(2)
                        , resultSet.getDouble(3), resultSet.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Product[] products = new Product[temp.size()];
        return temp.toArray(products);
    }

    @Override
    public Product[] selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Product object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Product object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
