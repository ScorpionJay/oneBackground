import React from 'react'

/* Inbox */
const Inbox = React.createClass({
	render() {
		return (
			<div>
				{this.props.children || "Welcome to your Inbox"}
			</div>
		);
	}
})

export default Inbox