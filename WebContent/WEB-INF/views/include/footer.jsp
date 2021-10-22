<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <script src="../assets/dist/js/bootstrap.bundle.min.js"></script> -->
	<script
		src="resources/assets/dist/js/bootstrap.bundle.min.js"></script>
<script>
var ckeditor = CKEDITOR.replace( 'messagebody' );
CKFinder.setupCKEditor(ckeditor, '${pageContext.request.contextPath}/resources/ckfinder/');
	
</script>

</body>
</html>