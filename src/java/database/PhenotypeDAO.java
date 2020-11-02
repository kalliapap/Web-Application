package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Gene;
import model.Phenotype;

/**
 *
 * @author vasiliki
 */
public class PhenotypeDAO {

    public static Phenotype getPhenotypeByName(String name) throws SQLException, ClassNotFoundException {

        Phenotype phenotype = null;
        Connection con = Connector.getConnection();
        String sql = "SELECT * FROM A_PHENOTYPE WHERE PHENOTYPEID = ?";
        if (con != null) {

            try {
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, name);
                ResultSet set = statement.executeQuery();
                if (set.next()) {
                    /*System.out.println("bika if oti exw"); */
                    phenotype = new Phenotype();
                    phenotype.setPhenotypeID(set.getString("PHENOTYPEID"));
                    phenotype.setDescription(set.getString("DESCRIPTION"));
                    phenotype.setPhenotypeTitle(set.getString("PHENOTYPETITLE"));
                    phenotype.setPhentext(set.getString("PHENTEXT"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(PhenotypeDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhenotypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (phenotype != null) {
                    System.out.println("connected epistrefw not null gene me " + phenotype.getPhenotypeTitle());
                }
                if (phenotype == null) {
                    System.out.println("connected epistrefw null gene");
                }

                return phenotype;
            }
        }

        if (phenotype != null) {
            System.out.println("not connected epistrefw not null gene me " + phenotype.getPhenotypeTitle());
        }
        if (phenotype == null) {
            System.out.println("not connected  epistrefw null gene");

        }
        return null;

    }

    public static Vector<Phenotype> getAllPhenotypes() throws SQLException, ClassNotFoundException {

        Vector<Phenotype> vec = new Vector<Phenotype>();
        Phenotype phenotype;
        Connection con = Connector.getConnection();
        String sql = "SELECT * FROM A_PHENOTYPE";
        if (con != null) {

            try {
                PreparedStatement statement = con.prepareStatement(sql);
                ResultSet set = statement.executeQuery();
                while(set.next()){
                    phenotype = new Phenotype();
                    phenotype.setPhenotypeID(set.getString("PHENOTYPEID"));
                    phenotype.setPhenotypeTitle(set.getString("PHENOTYPETITLE"));
                    phenotype.setPhentext(set.getString("PHENTEXT"));
                    phenotype.setDescription(set.getString("DESCRIPTION"));
                    vec.add(phenotype);                   
                    
                }
                set.close();

            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhenotypeDAO.class.getName()).log(Level.SEVERE, null, ex);   
                }
                for(Phenotype p:vec){
                    System.out.println(p.getPhenotypeID());
                }
                return vec; 
            }
            
            
        }
        return null;
    }

}
