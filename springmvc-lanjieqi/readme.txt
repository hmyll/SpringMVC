文件上传:

文件上传表单满足三个条件:
1）提交方式:POST
2）添加一个属性enctype,值为: multipart/form-data
3)至少具有一个file表单元素

文件上传需要用到apache提供的文件上传工具类，所以需要导入2个jar包:
1）文件上传核心jar包: commons-fileupload
2)文件上传的依赖包:commons-idI
