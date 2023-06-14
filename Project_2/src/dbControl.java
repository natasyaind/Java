

import config.MyConfig;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Products;


public class dbControl extends MyConfig{
    public static List<Products> getDatabase() {
        List<Products> produkList = new ArrayList<>();
        getConnection();
        try {
            // query = "SELECT nama, harga, stok FROM products ORDER BY ID DESC";
            query = "SELECT ID,NAMA, STOK, HARGA FROM products";

            preparedStatement = connect.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nama = resultSet.getString("NAMA");
                int harga = resultSet.getInt("HARGA");
                int stock = resultSet.getInt("STOK");

                Products produk = new Products(id, nama, stock, harga);
                produkList.add(produk);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produkList;
    }
    
    public static void updateHarga(int id, long harga) {
        getConnection();
        query = "UPDATE products SET HARGA=? WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setLong(1, harga);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateJumlah(int id, long jumlah) {
        getConnection();
        query = "UPDATE products SET STOCK=? WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setLong(1, jumlah);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean insertData(String nama, long harga, int jumlah) {
        getConnection();
        query = "INSERT INTO products (NAMA, HARGA, STOK) VALUES (?, ?, ?)";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setLong(2, harga);
            preparedStatement.setInt(3, jumlah);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }   
    
        public static void updateNama(int id, String nama) {
        getConnection();
        query = "UPDATE products SET NAMA=? WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
        public static boolean deleteData(int id) {
        getConnection();
        query = "DELETE FROM products WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int affectedRowDelete = preparedStatement.executeUpdate();
            if (affectedRowDelete > 0) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
