import React, {Component} from 'react';
import './Book.css';

class Book extends Component {
  render() {
    return <div className='book'>
      <div>{this.props.name} ({this.props.authorName}, {this.props.year})</div>
      <img alt={this.props.name} src={this.props.coverImageUrl} />
    </div>;
  }
}

export default Book;
