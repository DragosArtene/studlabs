//
//  NewsCellView.swift
//  Colectiv
//
//  Created by Lobont Andrei on 19/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class NewsCellView: UITableViewCell {
    @IBOutlet weak var newsImageView: UIImageView!
    @IBOutlet weak var newsHeadlineTitle: UILabel!
    @IBOutlet weak var newsHeadlineDescription: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
    }
    
    func setCell(with title: String, description: String, and image: String) {
        newsHeadlineTitle.text = title
        newsHeadlineDescription.text = description
        newsImageView.image = UIImage(named: image)
    }
}
