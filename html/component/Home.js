import React from 'react'
import $ from 'jquery'
import ProductList from './ProductList'
import Slider from './Slider/Slider';

const Home = React.createClass({

	// 组建挂载初始化值
	getInitialState(){
		return {
			data:[],
			slider:[]
		}
	},

	// 事件
	handleClick() {
		// alert(1);
		console.log($);
	},


	// 渲染完成
	componentDidMount(){
		console.log('componentDidMount');

		// get slider data
		$.ajax({
			url: 'json/slider.json',
			dataType: 'json',
			success: function(data){
				console.log('slider json');
				console.log(data);
				let slider = []
				data.map(item => slider.push({src:require('../img/' + item.src),alt:item.alt}))
				this.setState({slider:slider});
			}.bind(this),
			error: function(xhr, status, err){
				console.error(this.props.url, status, err.toString());
      		}.bind(this)
		});

		// get list data
		$.ajax({
			url: 'json/home.json',
			dataType: 'json',
			success: function(data){
				console.log('product json');
				console.log(data);
				this.setState({data: data});
			}.bind(this),
			error: function(xhr, status, err){
				console.error(this.props.url, status, err.toString());
      		}.bind(this)
		});
	},

	render() {
		return (
			<div className="home-content" >
				<Slider items={this.state.slider}/>
		 		<ProductList data={this.state.data}/>
		 	</div>
		)
	}

})


export default Home
