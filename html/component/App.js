import React from 'react'
import { Router, IndexRoute ,Route, hashHistory,Link,Redirect } from 'react-router'

import Home from './Home'
import About from './About'
import Inbox from './Inbox'
import Message from './Message'


/* App */
const App = React.createClass({
	render: function(){
		return (
			<div className="nav">
				<ul className="nav-ul">
					<li><Link to="/home" activeClassName="active">Home</Link></li>
					<li><Link to="/inbox" activeClassName="active">Inbox</Link></li>
					<li><Link to="/about" activeClassName="active">About</Link></li>
				</ul>
				<div className="content">{this.props.children}</div>
			</div>
		);
	}
})

/* routes */
const Routes = {
	path: '/',
	component: App,
	indexRoute :{component: Home},
	childRoutes: [
		{ path: 'home', component: Home},
		{ path: 'about', component: About},
		{
			path: 'inbox',
			component: Inbox,
			childRoutes : [{
				path: 'messages/:id',
				onEnter: ({ params }, replace) => replace(`/messages/${params.id}`)
			}]
		},
		{
			component: Inbox,
			childRoutes: [{
				path: 'messages/:id',component:Message
			}]
		}
	]
}


export default Routes