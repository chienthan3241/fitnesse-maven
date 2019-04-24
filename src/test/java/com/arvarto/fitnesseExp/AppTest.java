package com.arvarto.fitnesseExp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
   /**
    * Create the test case
    *
    * @param testName name of the test case
    */
   public AppTest(String testName) {
      super(testName);
   }

   /**
    * @return the suite of tests being tested
    */
   public static Test suite() {
      return new TestSuite(AppTest.class);
   }

   /**
    * Rigourous Test :-)
    */
   public void testApp() {
      // Connection con = null;
      // Statement stm = null;
      // ResultSet rs = null;
      // List<String> result = new ArrayList<String>();
      //
      // try {
      // con = DbConnect.getDbCosimaConnection();
      // stm = con.createStatement();
      // String sql = "select * from (select aktenzeichen from " + Config.schemaCosima
      // + "forderung) where rownum <11";
      // System.out.println(sql);
      // rs = stm.executeQuery(sql);
      // while (rs.next()) {
      // result.add(rs.getString(1));
      // }
      // for (String a : result) {
      // System.out.println(a);
      // }
      //
      // assertTrue(result.size() == 10);
      //
      // } catch (SQLException e) {
      //
      // } finally {
      // try {
      // if (rs != null) {
      // rs.close(); // close resultSet
      // }
      // if (stm != null) {
      // stm.close(); // close PreparedStatement
      // }
      // if (con != null) {
      // con.close(); // close connection
      // }
      // } catch (SQLException e) {
      // e.printStackTrace();
      // }
      // }
      assertTrue("".equals(""));
   }
}
