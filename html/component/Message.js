import React from 'react'
import $ from 'jquery'

/* Message */
 const Message = React.createClass({

 	// 组建挂载初始化值
	getInitialState(){
		return {
			data:[
				{"id":10}
			]
		}
	},


 	// 渲染完成
	componentDidMount(){
		console.log('componentDidMount' + this.props.params.id);

		$.ajax({
			url: 'json/home.json',
			dataType: 'json',
			success: function(data){
				console.log(data);

				//let item = data.map(item => {if(item.id===this.props.params.id){return item} }) 
				for (var i = 0; i<data.length; i++) {
					if(data[i].id == this.props.params.id){
						this.setState({data: data[i]});
						break
					}
				}

			}.bind(this),
			error: function(xhr, status, err){
				console.error(this.props.url, status, err.toString());
      		}.bind(this)
		});


	},


	render(){

		const {id,name,description} = this.state.data

		return <div>
					url参数 {this.props.params.id} 
					<div>{id}</div> 
					<div>{name}</div> 
					<div>{description}</div> 
				</div>
	}
})


export default Message