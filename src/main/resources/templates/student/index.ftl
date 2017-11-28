<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <title>学生首页</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">首页</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">信息</a>
                        </li>
                        <li>
                            <a href="#">选课</a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="form" method="get" action="/xdsys/student/search">
                        <div class="form-group">
                            <input type="text" name="searchText" class="form-control" />
                        </div>
                        <input hidden type="number" name="studentId" value="${student.studentId ? c}">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a >欢迎你，${student.studentName}，${student.studentId ? c}</a>
                        </li>
                        <li>
                            <a href="#">退出</a>
                        </li>
                    </ul>
                </div>

            </nav>
            <table class="table">
                <thead>
                <tr>
                    <th>
                        姓名
                    </th>
                    <th>
                        学号
                    </th>
                    <th>
                        已修学分
                    </th>
                    <th>
                        需修学分
                    </th>
                    <th>
                        入学时间
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                    ${student.studentName}
                    </td>
                    <td>
                    ${student.studentId ? c}
                    </td>
                    <td>
                    ${student.creditAcquired}
                    </td>
                    <td>
                    ${student.creditRequired}
                    </td>
                    <td>
                    ${student.entranceTime ? string("yyyy-MM-dd")}
                    </td>
                </tr>
                </tbody>
            </table>
            <br>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>
                        课程
                    </th>
                    <th>
                        老师
                    </th>
                    <th>
                        成绩
                    </th>
                    <th>
                        课程学分
                    </th>
                    <th>
                        上课地点
                    </th>
                </tr>
                </thead>
                <tbody>
                <#list courseVOList as course>
                <tr class="success">
                    <td>
                    ${course.courseName}
                    </td>
                    <td>
                    ${course.teacherName}
                    </td>
                    <td>
                    ${course.score}
                    </td>
                    <td>
                    ${course.courseCredit}
                    </td>
                    <td>
                    ${course.courseAddress}
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>