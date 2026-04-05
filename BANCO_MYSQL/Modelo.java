/**
 * Fecha: 4 Abril 2026 autor: Landeros Santos Jose Joel
 * 
 **/

package sistemabancario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo {
    private SistemaBancario sistemaBancario;

    public Modelo() {
        sistemaBancario = new SistemaBancario();

        int saldoRecuperado = obtenerSaldoBD();
        sistemaBancario.setSaldo(saldoRecuperado); 
    }

    public void setDeposito(int deposito) {
        int nuevoSaldo = sistemaBancario.getSaldo() + deposito;
        sistemaBancario.setSaldo(nuevoSaldo);
        actualizarSaldoBD(nuevoSaldo);
    }

    public boolean setRetiro(int retiro) {
        int saldoActual = sistemaBancario.getSaldo();
        if (retiro <= saldoActual) {
            int nuevoSaldo = saldoActual - retiro;
            sistemaBancario.setSaldo(nuevoSaldo);
            actualizarSaldoBD(nuevoSaldo);
            return true;
        }
        return false;
    }

  

    private int obtenerSaldoBD() {
        int saldo = 0;
        String sql = "SELECT saldo FROM CUENTA LIMIT 1";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                saldo = rs.getInt("saldo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saldo;
    }

    private void actualizarSaldoBD(int nuevoSaldo) {
  
        String sql = "UPDATE CUENTA SET saldo = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nuevoSaldo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSaldo() {
        return sistemaBancario.getSaldo();
    }
}