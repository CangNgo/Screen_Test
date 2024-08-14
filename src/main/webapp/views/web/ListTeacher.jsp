<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<div id="content">
    <div class="container mt-5">
        <div class="row d-flex justify-content-center">
            <div class="col-md-4 ">
                <form action="listTeacher" class="d-flex " method="get">
                    <input type="hidden" name="action" value="findByNameOrId">
                    <input type="text" name="findTeacher" class="form-control me-2" placeholder="Mã hoặc tên giảng viên">
                    <button type="submit" class="btn btn-primary">Tìm</button>
                </form>
            </div>
            <div class="col-md-4 ">
                <form action="listTeacher" method="get" class=" d-flex">
                    <input type="hidden" name="action" value="findByDegree">
                    <select class="form-select me-2" name="degree" aria-label="Default select example">
                        <option value="0">Tất cả</option>
                        <c:forEach var="degree" items="${listDegree}">
                            <option value="${degree.id}">${degree.degreeName}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary"><a
                                                                     class="text-bg-primary text-decoration-none">Lọc</a>
                    </button>
                </form>
            </div>
        </div>
        <div class="row d-flex justify-content-center mt-3">

            <div class="col-md-8">
                <button class="btn btn-lg btn-info"><a href="addTeacher?action=add"
                                                       class="text-decoration-none text-white">Thêm mới</a></button>
                <table class="table">
                    <tr>
                        <th>Mã</th>
                        <th>Họ tên</th>
                        <th>Lương</th>
                        <th>Ngày vào làm</th>
                        <th>Hình ảnh</th>
                        <th>Cập nhật</th>
                    </tr>
                    <tbody>
                    <c:forEach var="item" items="${listTeachers}">
                        <tr class="align-middle">
                            <td>${item.codeTeacher}</td>
                            <td>${item.lastName} ${item.firstName}</td>
                            <td><fmt:formatNumber value="${item.salary}" pattern="#,###.00"/></td>
                            <td><fmt:formatDate value="${item.firstDayOfWork}" pattern="dd-MM-yyyy"/></td>
                            <td><img src="<c:url value="/template/web/img/${item.image}" />" alt="" class="img-table">
                            </td>
                            <td><a href="addTeacher?action=update&id=${item.id}"
                                   class="text-decoration-none text-bg-primary btn">Cập
                                nhật</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
