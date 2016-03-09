package org.allenai.scienceparse.figureextraction

import org.allenai.scienceparse.figureextraction.FigureExtractor.{ DocumentWithSavedFigures, Document }
import org.allenai.scienceparse.figureextraction.SectionedTextBuilder.{ DocumentSection, PdfText }
import spray.json._

trait JsonProtocol extends DefaultJsonProtocol {
  // JSON formats so we can write Figures/Captions/Documents to disk
  implicit val boxFormat = jsonFormat4(Box.apply)
  implicit val captionFormat = jsonFormat5(Caption.apply)
  implicit val figureFormat = jsonFormat7(Figure.apply)
  implicit val savedFigureFormat = jsonFormat9(SavedFigure.apply)
  implicit val documentTextFormat = jsonFormat3(PdfText.apply)
  implicit val documentSectionFormat = jsonFormat2(DocumentSection.apply)
  implicit val documentFormat = jsonFormat3(Document.apply)
  implicit val documentWithFiguresFormat = jsonFormat3(DocumentWithSavedFigures.apply)
}

object JsonProtocol extends JsonProtocol