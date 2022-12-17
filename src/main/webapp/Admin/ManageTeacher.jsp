<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/output.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>

<body>
 <!-- Add Form -->
  <input class='hidden' type="checkbox" name="" id="openAdd">
  <div id='addForm'
    class='hidden bg-white fixed min-w-[350px] top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 p-8 rounded-md shadow-lg'>
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Thêm Sinh Viên Mới</h1>    
    <form class='' action="/DangKyDeTai/ManageStudent?type=insert" method="post">
      <div class="flex flex-col gap-2">
        <label class='' for="product-brand">Tên Sinh Viên</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="fullname"
          id="product-brand" placeholder='Nhập tên sinh viên...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Chuyên ngành</label>
        <select name="chuyennganh" id="chuyennganh" class='p-2 outline rounded-md outline-2 focus:outline-yellow-500'>
        <c:forEach items="${allchuyennganh}" var="rs">
		    <option value="<c:out value='${rs.getTenChuyenNganh()}' />">${rs.getTenChuyenNganh()}</option>
		</c:forEach>
		</select>
      </div>
      <!-- Color -->
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Email</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="email" name="email"
          id="product-brand" placeholder='Nhập địa chỉ email...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Số điện thoại</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" maxlength="10" name="phone"
          id="product-brand" placeholder='Nhập số điện thoại...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Địa chỉ</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" maxlength="10" name="address"
          id="product-brand" placeholder='Nhập địa chỉ...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Tên đăng nhập</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="username"
          id="product-brand" placeholder='Nhập tên đăng nhập...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Mật khẩu</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="password" name="password"
          id="product-brand" placeholder='Nhập mật khẩu...'>
      </div>
      
      <!-- Amount -->
      <br />
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md' type = "submit">Thêm</button>
      
      <button type='button' onclick='closeAddForm()'
        class='bg-gray-400 hover:bg-gray-300 text-center text-white p-2 mb-2 rounded-md shadow-md'>Hủy</button>
    </form>
  </div>
  
  
  
  <input class='hidden' type="checkbox" name="" id="openAdd">
  <div id='addForm1'
    class='hidden bg-white fixed min-w-[350px] top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 p-8 rounded-md shadow-lg'>
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Cập nhật thông tin </h1>
    <form class='' action="${pageContext.request.contextPath}/ThemLoaiDeTai" method="post">
      <div class="flex flex-col gap-2">
        <label class='' for="product-brand">Tên Sinh Viên</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="tenLoai"
          id="product-brand" placeholder='Nhập tên sinh viên...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Chuyên ngành</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="date" name="ngayBatDau"
          id="product-color" placeholder='Vui lòng ngày kết thúc đợt đăng ký...'>
      </div>
      <!-- Color -->
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Email</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="date" name="ngayKetThuc"
          id="product-color" placeholder='Vui lòng ngày kết thúc đợt đăng ký...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Số điện thoại</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="date" name="ngayKetThuc"
          id="product-color" placeholder='Vui lòng ngày kết thúc đợt đăng ký...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Tên đăng nhập</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="date" name="ngayKetThuc"
          id="product-color" placeholder='Vui lòng ngày kết thúc đợt đăng ký...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Mật khẩu</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="date" name="ngayKetThuc"
          id="product-color" placeholder='Vui lòng ngày kết thúc đợt đăng ký...'>
      </div>
      
      <!-- Amount -->
      <br />
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md' type = "submit">Thêm</button>
      
      <button type='button' onclick='closeAddForm()'
        class='bg-gray-400 hover:bg-gray-300 text-center text-white p-2 mb-2 rounded-md shadow-md'>Hủy</button>
    </form>
  </div>
  
  
  
  
  
  
  
  
  
  <main class='grid grid-cols-[200px_1fr] p-4 min-h-screen gap-4 max-w-[1200px] mx-auto pt-10'>

    <aside>
      <nav>
        <ul>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-gauge"></i>
            <a href="ManageStudent">Quản Lý Sinh Viên</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-money-bill"></i>
            <a href="ManageTeacher">Quản Lý Giảng Viên</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-user"></i>
            <a href="LoaiDeTaiAdmin">Quản Lý Đề Tài</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-shoe-prints"></i>
            <a href="ManagerProduct">Update....</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-chart-simple"></i>
            <a href="TopServlet">Update....</a>
          </li>
        </ul>
      </nav>
    </aside>
    
    <article>
      <div class='pb-4'>
        <h1 class='uppercase text-2xl font-semibold text-center p-4'>Quản Lý Giảng Viên</h1>

        <button onclick="openAddForm()"
          class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md'>Thêm Giảng Viên Mới</button>
        <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md'><a href = "/DangKyDeTai/UpdateInforTeacherAdmin">Cập Nhật Thông tin Giảng Viên</a></button>
        <table class='bg-gray-200 table-auto w-full shadow-md border-b-2 border-yellow-500'>
          <thead class='bg-yellow-500'>
            <tr>
              <th class='p-2 text-white'>Tên Giảng Viên</th>
              <th class='p-2 text-white'>Chuyên ngành</th>
              <th class='p-2 text-white'>Email</th>
              <th class='p-2 text-white'>Địa chỉ</th>
              <th class='p-2 text-white'>Số điện thoại</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            	<c:forEach items="${allstudent}" var="rs">
		        <tr class='bg-gray-100 odd:bg-gray-200' style='background-color: ;'>
	              
	              <td class='p-2 pl-4'>${rs.getInforaccount().getFullName()}</td>
	              <td class='p-2 pl-4'>${rs.getInforaccount().getChuyennganh().getTenChuyenNganh()}</td>
	              <td class='p-2 pl-4'>${rs.getInforaccount().getEmail()}</td>
	              <td class='p-2 pl-4'>${rs.getInforaccount().getAddress()}</td>
	              <td class='p-2 pl-4'>${rs.getInforaccount().getPhonenumber()}</td>
	              <td>
	              <a href = "/DangKyDeTai/ManageTeacher?type=delete&username=${rs.getInforaccount().getUserName()}">
	              <i class="fa-solid fa-delete-left hover:text-red-600 cursor-pointer"></i>
          		  </a>
	              
	              </td>
	            </tr>
                </c:forEach>
          </tbody>
        </table>
        <input id="check_insert" value="${checkinsert}" hidden /> 
        <input id="statusmanage" value="${statusmanage}" hidden /> 
         <input id="check_delete" value="${checkdelete}" hidden />
         <input id="check_update" value="${checkupdate}" hidden />
         <input id="check_update_p" value="${checkupdateproduct}" hidden />
         <input id="mess_update" value="${messupdate}" hidden />
         <input id="mess_delete" value="${messdelete}" hidden />
         <input id="mess_update_p" value="${messupdateproduct}" hidden />
      </div>
    </article>
  </main>
  <script>
	  const openAdd = document.getElementById('openAdd');
	  const addForm = document.getElementById('addForm');
	  function openAddForm() {
	    openAdd.checked = true;
	    openAdd.dispatchEvent(new Event('change'));
	  }
	
	  function closeAddForm() {
	    openAdd.checked = false;
	    openAdd.dispatchEvent(new Event('change'));
	  }
	
	  openAdd.addEventListener('change', () => {
	    if (openAdd.checked) {
	      addForm.classList.remove('hidden');
	    } else {
	      addForm.classList.add('hidden');
	    }
	  })
	 function showMessage(message, time) {
		var thongBao = document.querySelector('#thongBao');
				clearTimeout(timeoutId);
	            thongBao.style.display = "block";
	            thongBao.innerText=message;
	            timeoutId = setTimeout(() => {
					thongBao.style.display = "none";
				}, time)
	}
	let insertproduct = document.getElementById("check_insert");
	let deleteproduct = document.getElementById("check_delete");
	let updateproductstatus = document.getElementById("check_update");
	let updateproduct = document.getElementById("check_update_p");
	let checkstatus = document.getElementById("statusmanage");
	
	let messupdate = document.getElementById("mess_update");
	let messdelete = document.getElementById("mess_delete");
	let messupdateproduct = document.getElementById("mess_update_p");
	
	let checkinsert = insertproduct.value;
	let checkdelete = deleteproduct.value;
	let checkupdate = updateproduct.value;
	let checkupdatestatus = updateproductstatus.value;
	let status = checkstatus.value;
	
	let mess_up = messupdate.value;
	let mess_de = messdelete.value;
	let mess_upproduct = messupdateproduct.value;
	if (status === 'true'){
		if (checkinsert === 'true')
			swal("Thông Báo!", "Thêm Sản Phẩm Thành Công",
			"success");
		if (checkdelete === 'true')
		{
			if (mess_de === 'true')
				swal("Thông Báo!","Xóa Sản Phẩm Thành Công" ,"success");
			else
				swal("Thông Báo!","Sản Phẩm Đã Xóa" ,"error");
		}
		if (checkupdatestatus === 'true')
		{
			if (mess_up === 'true'){
				swal("Thông Báo!", "Hoàn Tác Sản Phẩm Thành Công",
				"success");
			}else{
				swal("Thông Báo!", "Sản Phẩm Không Được Hoàn Tác",
				"error");
			}
		}
		if (checkupdate === 'true')
		{
			if (mess_upproduct === 'true'){
				swal("Thông Báo!", "Cập Nhật Sản Phẩm Thành Công",
				"success");
			}else{
				swal("Thông Báo!", "Cập Nhật Sản Phẩm Không Thành Công",
				"error");
			}
		}
	}
  </script>
  
  <script>
	  const openAdd = document.getElementById('openAdd1');
	  const addForm = document.getElementById('addForm1');
	  function openAddForm1() {
	    openAdd.checked = true;
	    openAdd.dispatchEvent(new Event('change'));
	  }
	
	  function closeAddForm1() {
	    openAdd.checked = false;
	    openAdd.dispatchEvent(new Event('change'));
	  }
	
	  openAdd.addEventListener('change', () => {
	    if (openAdd.checked) {
	      addForm.classList.remove('hidden');
	    } else {
	      addForm.classList.add('hidden');
	    }
	  })
	 function showMessage(message, time) {
		var thongBao = document.querySelector('#thongBao');
				clearTimeout(timeoutId);
	            thongBao.style.display = "block";
	            thongBao.innerText=message;
	            timeoutId = setTimeout(() => {
					thongBao.style.display = "none";
				}, time)
	}
	let insertproduct = document.getElementById("check_insert");
	let deleteproduct = document.getElementById("check_delete");
	let updateproductstatus = document.getElementById("check_update");
	let updateproduct = document.getElementById("check_update_p");
	let checkstatus = document.getElementById("statusmanage");
	
	let messupdate = document.getElementById("mess_update");
	let messdelete = document.getElementById("mess_delete");
	let messupdateproduct = document.getElementById("mess_update_p");
	
	let checkinsert = insertproduct.value;
	let checkdelete = deleteproduct.value;
	let checkupdate = updateproduct.value;
	let checkupdatestatus = updateproductstatus.value;
	let status = checkstatus.value;
	
	let mess_up = messupdate.value;
	let mess_de = messdelete.value;
	let mess_upproduct = messupdateproduct.value;
	if (status === 'true'){
		if (checkinsert === 'true')
			swal("Thông Báo!", "Thêm Sản Phẩm Thành Công",
			"success");
		if (checkdelete === 'true')
		{
			if (mess_de === 'true')
				swal("Thông Báo!","Xóa Sản Phẩm Thành Công" ,"success");
			else
				swal("Thông Báo!","Sản Phẩm Đã Xóa" ,"error");
		}
		if (checkupdatestatus === 'true')
		{
			if (mess_up === 'true'){
				swal("Thông Báo!", "Hoàn Tác Sản Phẩm Thành Công",
				"success");
			}else{
				swal("Thông Báo!", "Sản Phẩm Không Được Hoàn Tác",
				"error");
			}
		}
		if (checkupdate === 'true')
		{
			if (mess_upproduct === 'true'){
				swal("Thông Báo!", "Cập Nhật Sản Phẩm Thành Công",
				"success");
			}else{
				swal("Thông Báo!", "Cập Nhật Sản Phẩm Không Thành Công",
				"error");
			}
		}
	}
  </script>
</body>

</html>