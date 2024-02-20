<%@ page import="com.directmedia.onlinestore.core.entity.Catalogue" %>
<%--
  Created by IntelliJ IDEA.
  User: eddbea
  Date: 10/02/2024
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${Catalogue.listOfWorks}" var="Liste">
   ${Liste.title}
   ${Liste.mainArtist.name}
   (${Liste.release})<br>
</c:forEach>