// 定义一个组件
export class ReactInnerHTMLByWillis extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        const {htmlContent} = this.props;
        return (<div dangerouslySetInnerHTML={{__html: htmlContent}}></div>);
    }
}