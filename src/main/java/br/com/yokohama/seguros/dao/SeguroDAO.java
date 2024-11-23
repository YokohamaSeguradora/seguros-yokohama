package br.com.yokohama.seguros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.yokohama.seguros.model.Seguro;
import br.com.yokohama.seguros.model.Seguro.TipoSeguro;

public class SeguroDAO {

    private Connection connection;

    public SeguroDAO(Connection connection) {
        this.connection = connection;
    }

    // insert
    public void insert(Seguro seguro) {
        String sql = "insert into seguro (tipo_seguro, id_automovel, id_usuario) values (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, seguro.getTipoSeguro().getCodigo());
            stmt.setLong(2, seguro.getIdAutomovel());
            stmt.setLong(3, seguro.getIdUsuario());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // delete
    public void delete(long id) {
        String sql = "delete from seguro where id_seguro=?";
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
    public void update(Seguro seguro) {
        String sql = "update seguro set tipo_seguro=?, id_automovel=?, id_usuario=? where id_seguro=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, seguro.getTipoSeguro().getCodigo());
            stmt.setLong(2, seguro.getIdAutomovel());
            stmt.setLong(3, seguro.getIdUsuario());
            stmt.setLong(4, seguro.getIdSeguro());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // selectAll
    public List<Seguro> selectAll() {
        List<Seguro> listaSeguros = new ArrayList<Seguro>();
        Seguro seguro;
        String sql = "select * from seguro order by tipo_seguro";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                seguro = new Seguro(TipoSeguro.fromCodigo(rs.getString("tipo_seguro")));
                seguro.setIdSeguro(rs.getLong("id_seguro"));
                seguro.setIdAutomovel(rs.getLong("id_automovel"));
                seguro.setIdUsuario(rs.getLong("id_seguro"));
                listaSeguros.add(seguro);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaSeguros;
    }

    // selectById
    public Seguro selectById(long id) {
        Seguro seguro = null;
        String sql = "select * from seguro where id_seguro=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                seguro = new Seguro(TipoSeguro.fromCodigo(rs.getString("tipo_seguro")));
                seguro.setIdSeguro(rs.getLong("id_seguro"));
                seguro.setIdAutomovel(rs.getLong("id_automovel"));
                seguro.setIdUsuario(rs.getLong("id_usuario"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seguro;
    }

    // selectByUser
    public List<Seguro> selectByUser(long idUsuario) {
        List<Seguro> listaSeguros = new ArrayList<>();
        Seguro seguro;
        String sql = "select * from seguro where id_usuario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                seguro = new Seguro(TipoSeguro.fromCodigo(rs.getString("tipo_seguro")));
                seguro.setIdSeguro(rs.getLong("id_seguro"));
                seguro.setIdAutomovel(rs.getLong("id_automovel"));
                seguro.setIdUsuario(rs.getLong("id_usuario"));
                listaSeguros.add(seguro);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaSeguros;
    }

    //select seguros by idUsuario
    public List<Seguro> buscarPorUsuario(long idUsuario) {
        List<Seguro> listaSeguros = new ArrayList<Seguro>();
        Seguro seguro;
        String sql = "SELECT * FROM seguro WHERE id_usuario = ? ORDER BY id_seguro";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idUsuario);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoSeguro tipoSeguro = TipoSeguro.fromCodigo(rs.getString("tipo_seguro"));
                long idAutomovel = rs.getLong("id_automovel");

                seguro = new Seguro(tipoSeguro);
                seguro.setIdSeguro(rs.getLong("id_seguro"));
                seguro.setIdUsuario(rs.getLong("id_usuario"));
                seguro.setIdAutomovel(idAutomovel);

                listaSeguros.add(seguro);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaSeguros;
    }

}
