const main = {
    init: function() {
        const _this = this;
        $('#btn-created').on('click', function () {
            _this.created();
        });
        $('#btn-check').on('click', function() {
            _this.check();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    created: function() {
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
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    check: function() {
        const data = {
            id: $('#id').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/check',
            contentType: 'application/json; charset-utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            window.location.href = "/post/modified/" + data.id;
        }).fail(function () {
            alert('비밀번호가 틀렸습니다.');
        })
    },
    update: function() {

    },
    delete: function() {

    }
}

main.init();
