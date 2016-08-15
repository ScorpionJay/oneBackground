import React,{Component} from 'react'
import ProductItem from './ProductItem'


export default class ProductList extends Component{

	render() {
		return <div>
					<ul>
						{
							// map
							// this.props.data.map(function(item){
							// 	return <li><ProductItem item={item} /></li>
							// })

							this.props.data.map( item => <li><ProductItem item={item} /></li> )
						}
					</ul>
				</div>
			
	}

} 