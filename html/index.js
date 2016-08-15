import React from 'react'
import { render } from 'react-dom'
import { Router,  hashHistory } from 'react-router'
import Routes from './component/App'

require('./sass/_main')


render(
<Router history={hashHistory} routes={Routes} />
,document.getElementById('root'))