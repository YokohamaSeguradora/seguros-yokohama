package br.com.yokohama.seguros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.yokohama.seguros.model.Fatura;
import br.com.yokohama.seguros.model.Fatura.StatusFatura;

public class FaturaDAO {

    private Connection connection;

    public FaturaDAO(Connection connection) {
        this.connection = connection;
    }

    // insert
    public void insert(Fatura fatura) {
        String sql = "insert into fatura (data_vencimento_fatura, status_fatura, valor_fatura, id_seguro) values (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, fatura.getDataVencimentoFatura());
            stmt.setString(2, fatura.getStatusFatura().name());
            stmt.setDouble(3, fatura.getValorFatura());
            stmt.setLong(4, fatura.getIdSeguro());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // delete
    public void delete(long id) {
        String sql = "delete from fatura where id_fatura=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update
    public void update(Fatura fatura) {
        String sql = "update fatura set data_vencimento_fatura=?, status_fatura=?, valor_fatura=?, id_seguro=? where id_fatura=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, fatura.getDataVencimentoFatura());
            stmt.setString(2, fatura.getStatusFatura().name());
            stmt.setDouble(3, fatura.getValorFatura());
            stmt.setLong(4, fatura.getIdSeguro());
            stmt.setLong(5, fatura.getIdFatura());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // selectAll
    public List<Fatura> selectAll() {
        List<Fatura> listaFaturas = new ArrayList<>();
        String sql = "select * from fatura order by data_vencimento_fatura";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fatura fatura = new Fatura();
                fatura.setIdFatura(rs.getLong("id_fatura"));
                fatura.setDataVencimentoFatura(rs.getDate("data_vencimento_fatura"));
                fatura.setStatusFatura(StatusFatura.valueOf(rs.getString("status_fatura")));
                fatura.setValorFatura(rs.getDouble("valor_fatura"));
                fatura.setIdSeguro(rs.getLong("id_seguro"));
                listaFaturas.add(fatura);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFaturas;
    }

    // selectById
    public Fatura selectById(long id) {
        Fatura fatura = null;
        String sql = "select * from fatura where id_fatura=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                fatura = new Fatura();
                fatura.setIdFatura(rs.getLong("id_fatura"));
                fatura.setDataVencimentoFatura(rs.getDate("data_vencimento_fatura"));
                fatura.setStatusFatura(StatusFatura.valueOf(rs.getString("status_fatura")));
                fatura.setValorFatura(rs.getDouble("valor_fatura"));
                fatura.setIdSeguro(rs.getLong("id_seguro"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fatura;
    }
}
