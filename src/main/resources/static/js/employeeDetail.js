$(document).ready(function() {
    // ページの読み込みが完了した時の処理
    // DOMの準備ができたら、jQueryを使って以下の処理を実行する
    // これは、HTMLが完全に読み込まれ、解析されてから実行されます。
    
    $('.employeeId').on('click', function() {
        // 「employeeId」というクラス名を持つ要素がクリックされた時の処理
        // クリックされた要素のテキストを取得する
        var employeeId = $(this).text();
        
        // Ajaxリクエストを送信する
        $.ajax({
            // リクエスト先のURL
            url: '/employeeDetail/' + employeeId,
            // HTTPリクエストの種類
            type: 'GET',
            // 応答のデータの型
            dataType: 'json',
            success: function(data) {
                // リクエストが成功した場合の処理
                // モーダルを表示する
                $('#employeeDetailModal').modal('show');
                
                // 応答のデータから値を取得して、モーダル内の要素にセットする
                $('.modal-body #employeeName').text(data.employeeName);
                $('.modal-body #age').text(data.age);
                $('.modal-body #serviceYears').text(data.serviceYears);
                $('.modal-body #position').text(data.position);
                $('.modal-body #salary').text(data.salary);
                $('.modal-body #paidBalance').text(data.paidBalance);
                $('.modal-body #closestSt').text(data.closestSt);
                $('.modal-body #pjName').text(data.pjName);
                $('.modal-body #pjMember').text(data.pjMember);
                $('.modal-body #pjPeriod').text(data.pjPeriod);
            },
            error: function() {
                // リクエストが失敗した場合の処理
                alert('Error!');
            }
        });
    });
});