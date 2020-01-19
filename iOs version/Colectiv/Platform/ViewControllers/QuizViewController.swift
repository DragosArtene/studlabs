//
//  QuizViewController.swift
//  Colectiv
//
//  Created by Andrei Lobont on 13/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class QuizViewController: UICollectionViewController {
    lazy var presenter: QuizPresenter = QuizPresenter(view: self, navigation: self)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.viewDidLoad()
        
    }
}

extension QuizViewController {
    override func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return presenter.numberOfQuizes()
    }
    
    override func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView
            .dequeueReusableCell(withReuseIdentifier: "QuizCell", for: indexPath) as! QuizCellView
        
        
        let currentQuiz = presenter.getQuiz(at: indexPath.row)
        cell.setCell(with: currentQuiz.title, and: currentQuiz.imageName)
        cell.layer.borderColor = UIColor.black.cgColor
        cell.layer.borderWidth = 1
        cell.layer.cornerRadius = cell.frame.width / 3
        
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
        return UIEdgeInsets(top: 20, left: 10, bottom: 10, right: 10)
    }
    
    override func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        presenter.selected(quiz: indexPath.row)
    }
}

extension QuizViewController: QuizView {
    
}

extension QuizViewController: QuizNavigation {
    func navigateToQuestions(with quiz: Quiz) {
        guard let viewController = UIStoryboard(name: "Quiz", bundle: nil).instantiateViewController(identifier: "Question") as? QuestionViewController else { return }
        let presenter: QuestionPresenter = QuestionPresenter(view: viewController, navigation: viewController, quiz: quiz)
        viewController.presenter = presenter
        self.navigationController?.pushViewController(viewController, animated: true)
    }
}
