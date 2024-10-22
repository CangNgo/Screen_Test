<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<div id="content">
    <div class="container mt-5">
        <form action="addTeacher?action=add" id="teacherForm" method="post" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="maGV" class="form-label d-flex">Mã giảng viên <p
                                class="message-maGV ms-2 visually-hidden text-danger mb-0">(*)
                        </p>
                        </label>
                        <input type="text" name="codeTeacher" class="form-control" id="maGV"
                               value="${teacher.codeTeacher}">
                    </div>
                    <div class="mb-3">
                        <label for="lastName" class="form-label d-flex">Họ giảng viên<p
                                class="message-lastName ms-2 visually-hidden text-danger mb-0">(*)
                        </p></label>
                        <input type="text" name="lastName" class="form-control" id="lastName"
                               value="${teacher.lastName}">
                    </div>
                    <div class="mb-3">
                        <label for="firstName" class="form-label d-flex">Tên giảng viên<p
                                class="message-firstName ms-2 visually-hidden text-danger mb-0">(*)
                        </p></label>
                        <input type="text" name="firstName" class="form-control" id="firstName"
                               value="${teacher.firstName}">
                    </div>
                    <div class="mb-3">
                        <label for="salary" class="form-label d-flex">Lương cơ bản<p
                                class="message-salary ms-2 visually-hidden text-danger mb-0">(*)
                        </p></label>
                        <input type="number" name="salary" class="form-control" id="salary" value="${teacher.salary}">
                    </div>

                </div>
                <div class="col-md-4">
                    <div class="mb-3">
                        <label class="form-label">Bằng cấp</label>
                        <select class="form-select" id="degree" name="degree" aria-label="Default select example">
                            <c:if test="${not empty teacher.degreeId.degreeName}">
                                <option selected value="${teacher.degreeId}">${teacher.degreeId.degreeName}</option>
                            </c:if>
                            <c:forEach var="degree" items="${listDegree}">
                                <option value="${degree.id}">${degree.degreeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Hợp đồng</label>
                        <select class="form-select" id="contract" name="contract" aria-label="Default select example">
                            <c:if test="${not empty teacher.contractId.contractName}">
                                <option selected value="${teacher.contractId}">${teacher.contractId.contractName}</option>
                            </c:if>
                            <c:forEach var="contract" items="${listContract}" >
                                <option value="${contract.id}">${contract.contractName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="firstDayOfWork" class="form-label d-flex">Ngày bắt đầu làm<p
                                class="message-firstDayOfWork ms-2 visually-hidden text-danger mb-0">(*)
                        </p></label>
                        <input type="date" name="firstDayOfWork" class="form-control" id="firstDayOfWork"
                               value="${teacher.firstDayOfWork}">
                    </div>
                    <input type="hidden" name="id" value="${teacher.id}">
                    <div class="mb-3 mt-5 justify-content-end d-flex">
                        <button type="submit" class="btn btn-secondary w-50  me-3" id="btn-submit-update"
                                onclick="submitForm('update')">Cập nhật
                        </button>
                        <button type="submit" class="btn btn-primary w-50 " id="btn-submit"
                                onclick="submitForm('add')">Thêm
                        </button>
                    </div>
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">${message}</div>
                    </c:if>
                </div>
                <div class="col-md-4 d-flex justify-content-center align-items-center flex-column">
                    <div class="box-img border border-1 ">
                        <c:if test="${not empty teacher.image}">
                            <img
                                    src="<c:url value="/template/web/img/${teacher.image}" />"
                                    class="img-thumbnail image-teacher" alt="image" id="img-teacher">
                        </c:if>
                        <c:if test="${empty teacher.image}">
                            <img
                                    src="data:image/png;base64,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"
                                    class="img-thumbnail image-teacher" alt="image" id="img-teacher">
                        </c:if>
                    </div>
                    <input type="file" name="choiceImage" id="choiceImage"
                           class="form-control w-75 mt-3">
                </div>
            </div>
        </form>
    </div>
    <button class="btn btn-lg btn-info ms-3"><a href="listTeacher" class="text-decoration-none text-black">Danh sách
        giảng viên</a></button>
</div>