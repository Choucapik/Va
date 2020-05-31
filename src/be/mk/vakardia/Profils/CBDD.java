package be.mk.vakardia.Profils;

import javafx.util.Pair;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.sql.*;

public class CBDD {

    private Connection connection;

    private String urlbase,host,database,utilisateur,mdp;


    public CBDD(String urlbase, String host, String database, String utilisateur, String mdp) {
        this.urlbase = urlbase;
        this.host = host;
        this.database = database;
        this.utilisateur = utilisateur;
        this.mdp = mdp;
    }
    public CBDD connection() {
        if(!checkconnect()) {
            try {
                try {
                    //Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(urlbase + host + "/" + database, utilisateur, mdp);
                    System.out.println(ChatColor.DARK_GREEN + "Base de donné connecté !");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
    public Pair<Statement,ResultSet> procedure(String s){
        Statement stat = null;
        ResultSet resel = null;
        try {
            connection();
            stat = connection.createStatement();
            resel = stat.executeQuery(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Pair<Statement, ResultSet>(stat,resel);
    }
    public void disconnect() {
        if(checkconnect()) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public Boolean checkconnect()
    {
        return  connection != null;

    }
    public  void addprofil(Player p,Double m,String race,String job,String roy){
        if(!hasprofil(p)){
            try {

                PreparedStatement ps = connection.prepareStatement("INSERT INTO playerdata(id,pseudo,money,race,job,roy) VALUES (?,?,?,?,?,?)");
                ps.setString(1,p.getUniqueId().toString());
                ps.setString(2,p.getName());
                ps.setString(3, String.valueOf(m));
                ps.setString(4, String.valueOf(race));
                ps.setString(5, String.valueOf(job));
                ps.setString(6, String.valueOf(roy));
                ps.execute();
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void udpate(Player p,Double m,String race,String job,String roy){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE playerdata SET pseudo="+p.getName()+",money="+m+",race="+race+",job="+job+",roy="+roy+" WHERE id="+p.getUniqueId());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public boolean hasprofil(Player p){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT id FROM playerdata WHERE id="+p.getUniqueId().toString() );

            ResultSet result = ps.executeQuery();
            boolean hasprofil = result.next();
            ps.close();
            return hasprofil;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
    public double getmoney(Player p){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT money FROM playerdata WHERE id ?");
            ps.setString(1,p.getUniqueId().toString());

            double Money = 0;
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Money = rs.getDouble("money");
            }
            ps.close();
            return Money;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public void addmoney(Player p, double money){

    }
    public void removemoney(Player p, double money){

    }
    public void setmoney(Player p, double money){

    }


}
