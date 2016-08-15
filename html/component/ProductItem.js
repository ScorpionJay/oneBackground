import React,{Component} from 'react'
import { Link } from 'react-router'


export default class ProductItem extends Component{

	handleClick(e){
		console.log(e.target.value);
	};

	render() {

		const { name,id } = this.props.item

		return  <Link to={ `/messages/${id}` } >
					<div style={{clear:'both',marginTop:10,height:50}} className='item' onClick={this.handleClick} value={id}>
						<span className="left">{name}</span>
						<span className="right"> > </span>
					</div>
				</Link>
			
	}

} 