package br.com.yokohama.seguros.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.yokohama.seguros.model.Automovel;
import br.com.yokohama.seguros.model.Automovel.TipoAutomovel;

public class AutomovelDAO {
	private Connection connection;

    public AutomovelDAO(Connection connection) {
        this.connection = connection;
    }

    // insert
    public void insert(Automovel automovel) {
        String sql = "INSERT INTO automovel (tipo_automovel, placa_automovel, renavam_automovel, " +
                     "modelo_automovel, data_modelo_automovel, data_fabricacao_automovel, cep_pernoite_automovel) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, automovel.getTipoAutomovel().getCodigo());
            stmt.setString(2, automovel.getPlacaAutomovel());
            stmt.setString(3, automovel.getRenavamAutomovel());
            stmt.setString(4, automovel.getModeloAutomovel());
            stmt.setDate(5, new Date(automovel.getDataModeloAutomovel().getTime()));
            stmt.setDate(6, new Date(automovel.getDataFabricacaoAutomovel().getTime()));
            stmt.setString(7, automovel.getCepPernoiteAutomovel());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // delete
    public void delete(long idAutomovel) {
        String sql = "DELETE FROM automovel WHERE id_automovel=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idAutomovel);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update
    public void update(Automovel automovel) {
        String sql = "UPDATE automovel SET tipo_automovel=?, placa_automovel=?, renavam_automovel=?, " +
                     "modelo_automovel=?, data_modelo_automovel=?, data_fabricacao_automovel=?, " +
                     "cep_pernoite_automovel=? WHERE id_automovel=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, automovel.getTipoAutomovel().getCodigo());
            stmt.setString(2, automovel.getPlacaAutomovel());
            stmt.setString(3, automovel.getRenavamAutomovel());
            stmt.setString(4, automovel.getModeloAutomovel());
            stmt.setDate(5, new Date(automovel.getDataModeloAutomovel().getTime()));
            stmt.setDate(6, new Date(automovel.getDataFabricacaoAutomovel().getTime()));
            stmt.setString(7, automovel.getCepPernoiteAutomovel());
            stmt.setLong(8, automovel.getIdAutomovel());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // selectAll
    public List<Automovel> selectAll() {
        List<Automovel> listaAutomoveis = new ArrayList<>();
        String sql = "SELECT * FROM automovel ORDER BY modelo_automovel";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Automovel automovel = new Automovel(TipoAutomovel.fromCodigo(rs.getString("tipo_automovel")));
                automovel.setIdAutomovel(rs.getLong("id_automovel"));
                automovel.setPlacaAutomovel(rs.getString("placa_automovel"));
                automovel.setRenavamAutomovel(rs.getString("renavam_automovel"));
                automovel.setModeloAutomovel(rs.getString("modelo_automovel"));
                automovel.setDataModeloAutomovel(rs.getDate("data_modelo_automovel"));
                automovel.setDataFabricacaoAutomovel(rs.getDate("data_fabricacao_automovel"));
                automovel.setCepPernoiteAutomovel(rs.getString("cep_pernoite_automovel"));
                listaAutomoveis.add(automovel);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAutomoveis;
    }

    // selectById
    public Automovel selectById(long idAutomovel) {
        Automovel automovel = null;
        String sql = "SELECT * FROM automovel WHERE id_automovel=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idAutomovel);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                automovel = new Automovel(TipoAutomovel.fromCodigo(rs.getString("tipo_automovel")));
                automovel.setIdAutomovel(rs.getLong("id_automovel"));
                automovel.setPlacaAutomovel(rs.getString("placa_automovel"));
                automovel.setRenavamAutomovel(rs.getString("renavam_automovel"));
                automovel.setModeloAutomovel(rs.getString("modelo_automovel"));
                automovel.setDataModeloAutomovel(rs.getDate("data_modelo_automovel"));
                automovel.setDataFabricacaoAutomovel(rs.getDate("data_fabricacao_automovel"));
                automovel.setCepPernoiteAutomovel(rs.getString("cep_pernoite_automovel"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return automovel;
    }
}
