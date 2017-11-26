import $ from 'jquery';

export class Message {
    public constructor(private msg: String) {

    }

    public show() {
        alert(this.msg);
    }

    public appendToBody() {
        $('body').append(`<div>${this.msg}</div>`);
    }
}
