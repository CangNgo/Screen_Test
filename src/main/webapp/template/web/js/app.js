const img = document.querySelector("#img-teacher");
const input = document.querySelector("#choiceImage");
input.addEventListener("change", () => {
    img.src = URL.createObjectURL(input.files[0]);
});

function checkForm() {
    const maGV = document.getElementById("maGV");
    const lastName = document.querySelector("#lastName");
    const firstName = document.querySelector("#firstName");
    const salary = document.querySelector("#salary");
    const firstDayOfWork = document.querySelector("#firstDayOfWork");
    let isEmpty = false;
    //kiểm tra mã gv
    if (maGV.value.trim() === "") {
        isEmpty = true;
        document.querySelector(".message-maGV").classList.remove("visually-hidden");
    } else {
        document.querySelector(".message-maGV").classList.add("visually-hidden");
    }

    if (lastName.value.trim() === "") {
        isEmpty = true;
        document
            .querySelector(".message-lastName")
            .classList.remove("visually-hidden");
    } else {
        document
            .querySelector(".message-lastName")
            .classList.add("visually-hidden");
    }

    if (firstName.value.trim() === "") {
        isEmpty = true;
        document
            .querySelector(".message-firstName")
            .classList.remove("visually-hidden");
    } else {
        document
            .querySelector(".message-firstName")
            .classList.add("visually-hidden");
    }

    if (salary.value.trim() === "") {
        isEmpty = true;
        document
            .querySelector(".message-salary")
            .classList.remove("visually-hidden");
    } else {
        document.querySelector(".message-salary").classList.add("visually-hidden");
    }

    if (firstDayOfWork.value.trim() === "") {
        isEmpty = true;
        document
            .querySelector(".message-firstDayOfWork")
            .classList.remove("visually-hidden");
    } else {
        document
            .querySelector(".message-firstDayOfWork")
            .classList.add("visually-hidden");
    }

    //nếu có trường hợp rỗng thì không submit
    if (isEmpty) {
        // Display error messages (you can use alert, show them on the page, etc.)
        document.querySelector("#btn-submit").type = "button";
        document.querySelector("#btn-submit-update").type = "button";
        return false; // Prevent form submission if there are errors
    } else {
        document.querySelector("#btn-submit").type = "submit";
        document.querySelector("#btn-submit-update").type = "submit";
    }

    // If all fields are valid, submit the form (assuming you have a form submission logic)
    return true; // Allow form submission
}

//submit
function submitForm(action) {
    var form = document.getElementById('teacherForm');
    form.action = 'addTeacher?action=' + action;

    if (checkForm()) {  // Giả sử bạn đã có hàm checkForm() để kiểm tra form
        form.submit();
    }
}
