const main = {
    init: function () {
        let path;
        const _this = this;
        $('#btn-created').on('click', function () {
            _this.created();
        });
        $('#btn-check').on('click', function () {
            _this.check(path);
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#delete').on('click', function () {
            path = 'delete';
        });
        $('#update').on('click', function () {
            path = 'update';
        });
    },
    created: function () {
        const data = {
            title: $('#title').val(),
            content: $('#content').val(),
            author: $('#author').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/created',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (id) {
            alert('글이 등록되었습니다.');
            window.location.href = '/post/detail/' + id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    check: function (path) {
        const data = {
            id: $('#id').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/check',
            contentType: 'application/json; charset-utf-8',
            data: JSON.stringify(data)
        }).done(function (check) {
            let url;
            if (check) {
                if (path == 'delete') {
                    $.ajax({
                        type: 'DELETE',
                        url: '/api/delete/' + data.id
                    }).done(function () {
                        window.location.href = '/post/1';
                    }).fail(function () {
                        alert('글을 삭제할 수 없습니다.');
                    })
                } else {
                    window.location.href = '/post/update/' + data.id;
                }
            } else {
                alert("비밀번호가 틀렸습니다.");
            }
        })
    },
    update: function () {
        const data = {
            id: $('#id').val(),
            title: $('#title').val(),
            content: $('#content').val(),
            author: $('#author').val(),
            password: $('#password').val()
        };

        $.ajax({
            method: 'PATCH',
            url: '/api/update',
            contentType: 'application/json; charset-utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글을 수정했습니다.');
            window.location.href = "/post/detail/" + data.id;
        }).fail(function () {
            alert('글을 수정할 수 없습니다.');
            window.location.href = "/post/detail/" + data.id;
        });
    }
}

main.init();
