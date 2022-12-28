<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
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
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Thêm sản phẩm</h1>
    <form class='' action="${pageContext.request.contextPath}/ThemDeTai" method="post">
      <div class="flex flex-col gap-2">
        <label class='' for="product-name">Tên đề tài</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="tendetai"
          id="tendetai" placeholder='Vui lòng nhập tên đề tài'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-category">Chuyên Ngành</label>
        	<select name="chuyennganh" id="chuyennganh">
        	  <option value="1">Công Nghệ Phần Mềm</option>
	          <option value= "2" >Hệ Thống Thông Tin</option>
	          <option value= "2" >Mạng Máy Tính</option>
	        </select>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-brand">Niên Khóa</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="nienkhoa"
          id="nienkhoa" placeholder='Vui lòng nhập niên khóa...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-brand">Mục Tiêu</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="muctieu"
          id="muctieu" placeholder='Vui lòng nhập mục tiêu...'>
      </div>
      <!-- Color -->
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Yêu Cầu</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="yeucau"
          id="yeucau" placeholder='Vui lòng nhập yêu cầu...'>
      </div>
      
      
      <div class="flex flex-col gap-2">
        <label class='' for="product-desc">Sản Phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="sanpham"
          id="sanpham" placeholder='Nhập mô tả sản phẩm làm được..'>
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
            <a href="DashBoard">Quản Lý Sinh Viên</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-money-bill"></i>
            <a href="BillManagement">Quản Lý Giảng Viên</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-user"></i>
            <a href="LoaiDeTaiTBM">Quản Lý Đề Tài</a>
          </li>
        </ul>
      </nav>
    </aside>
    
    <article>
      <div class='pb-4'>
        <h1 class='uppercase text-2xl font-semibold text-center p-4'>Quản lý đề tài</h1>

        
        <c:if test="${fn:length(listD) == 0}">
        			<br>
        			<br>
          			<h1 class="uppercase text-2xl font-semibold text-center p-4" style="
						    color: red;
						    font-style: italic;
						">Chưa có đề tài nào trong loại đề tài này</h1>
        </c:if>
        <c:if test="${fn:length(listD) > 0}">
        <table class='bg-gray-200 table-auto w-full shadow-md border-b-2 border-yellow-500'>
          <thead class='bg-yellow-500'>
            <tr>
              <th class='p-2 text-white'>Tên Đề Tài</th>
              <th class='p-2 text-white'>Chuyên Ngành</th>
              <th class='p-2 text-white'>GVHD</th>
              <th class='p-2 text-white'>GVPB</th>
              <th class='p-2 text-white'>Chi Tiết</th>
            </tr>
          </thead>
          <tbody>
          		
            	<c:forEach begin="0" end="${fn:length(listD) - 1}" step="1" varStatus="position">
			        <tr class='bg-gray-100 odd:bg-gray-200' style='background-color: ;'>
		              <td class='p-2 pl-4'>${listD[position.current].tenDeTai}</td>
		              <td class='p-2 pl-4'>${listD[position.current].chuyennganh.tenChuyenNganh}</td>
		              
		              <c:if test="${listDK[position.current].account.username != '' and listDK[position.current] != null}">
		              	<td class='p-2 pl-4'>${listDK[position.current].account.inforaccount.fullName}</td>
		              </c:if>
		              <c:if test="${listDK[position.current].account.username == '' or listDK[position.current] == null}">
		              	<td class='p-2 pl-4'>Chưa có</td>
		              </c:if>
		              <c:if test="${listGVPB[position.current] != null }">
		              	<td class='p-2 pl-4 flex justify-center gap-4 items-center'>${listGVPB[position.current].fullName}</td>
		              </c:if>
		              <c:if test="${listGVPB[position.current] == null }">
		              	<td class='p-2 pl-4 flex justify-center gap-4 items-center'>Chưa có</td>
		              </c:if>
		              <td>
		              <button>
	                  		<i></i>
		              </button>
		              <a href ="GetDeTaiTBM?idDeTai=${listD[position.current].idDeTai}">
		              <button>
	                  		<i class="fa-solid fa-pen-to-square hover:text-yellow-500 cursor-pointer"></i>
		              </button>
		              <a href="GetDangKy?idDeTai=${listD[position.current].idDeTai}">
		              <button>
							<i class="fas fa-sync-alt hover:text-red-600 cursor-pointer"></i>
		              </button>
		              </a>          
		              </td>
		            </tr>
            	</c:forEach>
          </tbody>
        </table>
        </c:if>
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
  </script>
</body>

</html>