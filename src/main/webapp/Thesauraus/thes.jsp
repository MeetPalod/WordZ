<%-- 
    Document   : thes
    Created on : 16-Apr-2020, 12:50:31 pm
    Author     : HP
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../thesauraus/style.css" rel="stylesheet" type="text/css">
        <title>WORDZ THESAURAUS</title>
    </head>
        </head>
    <body>
        <div class="container">
            
                <h2>WORDZ Theasauraus</h2>
<!--                <form id="thesForm">
                    <ul class="input-list mystyle clearfix">
                        <li >
                            <input type="text" id="word"  placeholder="Enter your word">
                        </li>
                        <li>
                            <input id="search" type="submit" value="Look up">
                        </li>
                    </ul>
                </form>-->
                <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                url="jdbc:mysql://localhost:3306/thesauraus"
                user="root"  password="meetpalod"/>
 
                    
                
                        <sql:query dataSource="${db}" var="rs">
                            select synonym from synonyms where word_id = (select word_id from synonyms where synonym = "acumen") ;
                        </sql:query>
                        <div id="result">
                            <table>
                                <tr>
                                    <th>Synonyms</th>
                                </tr>
                                <c:forEach var="row" items="${rs.rows}">
                                    <tr>
                                        <td><c:out value="${row.synonym}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                
                
        </div>
    </body>
</html>

