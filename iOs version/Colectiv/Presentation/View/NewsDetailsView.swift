//
//  NewsDetailsView.swift
//  Colectiv
//
//  Created by Lobont Andrei on 19/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

protocol NewsDetailsView: class {
    func displayImage(with image: String)
    func displayHeader(with title: String)
    func displayDescription(with descriptiom: String)
}
